package com.example.ADU7EX01_EL_Franky.Ingestors.Batch;

import com.example.ADU7EX01_EL_Franky.Services.PostService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@Component
public class ReservaBatchImporter {

    // Rutas a los directorios de trabajo
    private static final String PENDENT_DIR = "src/main/resources/Reserves/Pendents/";
    private static final String CORRECTE_DIR = "src/main/resources/Reserves/Correctes/";
    private static final String ERROR_DIR = "src/main/resources/Reserves/errors/";
    private static final String ENDPOINT_URL = "http://localhost:8080/reservas";

    // Recogida de datos cada 120 segundos
    @Scheduled(fixedRate = 12000)
    public void ingestarFitxers() {
        try (Stream<Path> files = Files.list(Paths.get(PENDENT_DIR))) {
            files.filter(path -> path.toString().endsWith(".json") || path.toString().endsWith(".xml"))
                    .forEach(ReservaBatchImporter::processFile);
        } catch (IOException e) {
            System.err.println("Error llegint directori: " + e.getMessage());
        }
    }

    // Procesamos un archivo individual (JSON o XML)y lo convertims a JSON si es necesario
    private static void processFile(Path filePath) {
        try {

            JSONObject json;

            // Lee el archivo según su tipo y lo convierte a JSONObject
            if (filePath.toString().endsWith(".json")) {
                String content = Files.readString(filePath);
                json = new JSONObject(content);
            } else {
                json = parseXmlToJson(filePath);
            }

            // Envía el JSON al endpoint del Post
            boolean success = PostService.sendToService(json, ENDPOINT_URL);

            // Mueve el archivo a la carpeta de éxito o error según el resultado
            Path targetPath = Paths.get(success ? CORRECTE_DIR : ERROR_DIR, filePath.getFileName().toString());
            Files.move(filePath, targetPath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Fitxer " + filePath.getFileName() + " -> " + (success ? "correcte" : "error"));

        } catch (Exception e) {
            System.err.println("Error processant fitxer: " + filePath.getFileName() + " - " + e.getMessage());
            try {
                Files.move(filePath, Paths.get(ERROR_DIR, filePath.getFileName().toString()), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                System.err.println("No s'ha pogut moure a errors: " + ex.getMessage());
            }
        }
    }

    // Convertimos un archivo XML con datos de reserva a un objeto JSONObject
    private static JSONObject parseXmlToJson(Path filePath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(filePath.toFile());
        doc.getDocumentElement().normalize();

        Element reserva = doc.getDocumentElement();
        JSONObject json = new JSONObject();

        // Extrae datos básicos de la reserva
        json.put("checkIn", reserva.getElementsByTagName("checkIn").item(0).getTextContent());
        json.put("checkOut", reserva.getElementsByTagName("checkOut").item(0).getTextContent());
        json.put("numHabitaciones", Integer.parseInt(reserva.getElementsByTagName("numHabitaciones").item(0).getTextContent()));

        // Extrae ID del hotel
        JSONObject hotel = new JSONObject();
        hotel.put("id", Integer.parseInt(((Element) reserva.getElementsByTagName("hotel").item(0)).getElementsByTagName("id").item(0).getTextContent()));
        json.put("hotel", hotel);

        // Extrae ID de la persona
        JSONObject persona = new JSONObject();
        persona.put("id", Integer.parseInt(((Element) reserva.getElementsByTagName("persona").item(0)).getElementsByTagName("id").item(0).getTextContent()));
        json.put("persona", persona);

        // Extrae ID del tipo de habitación
        JSONObject tipoHabitacion = new JSONObject();
        tipoHabitacion.put("id", Integer.parseInt(((Element) reserva.getElementsByTagName("tipoHabitacion").item(0)).getElementsByTagName("id").item(0).getTextContent()));
        json.put("tipoHabitacion", tipoHabitacion);

        return json;
    }
}
