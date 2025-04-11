package com.example.ADU7EX01_EL_Franky.Ingestors.Batch;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.json.JSONObject;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.*;
import java.util.stream.Stream;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@Component
public class ReservaBatchImporter {

    private static final String PENDENT_DIR = "src/main/resources/Reserves/Pendents/";
    private static final String CORRECTE_DIR = "src/main/resources/Reserves/Correctes/";
    private static final String ERROR_DIR = "src/main/resources/Reserves/errors/";
    private static final String ENDPOINT_URL = "http://localhost:8080/reservas";

    // Recogida de datos cada 60 segundos
    @Scheduled(fixedRate = 60000)
    public void ingestarFitxers() {
        try (Stream<Path> files = Files.list(Paths.get(PENDENT_DIR))) {
            files.filter(path -> path.toString().endsWith(".json") || path.toString().endsWith(".xml"))
                    .forEach(ReservaBatchImporter::processFile);
        } catch (IOException e) {
            System.err.println("Error llegint directori: " + e.getMessage());
        }
    }

    private static void processFile(Path filePath) {
        try {
            JSONObject json;
            if (filePath.toString().endsWith(".json")) {
                String content = Files.readString(filePath);
                json = new JSONObject(content);
            } else {
                json = parseXmlToJson(filePath);
            }

            boolean success = sendToService(json);

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

    private static JSONObject parseXmlToJson(Path filePath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(filePath.toFile());
        doc.getDocumentElement().normalize();

        Element reserva = doc.getDocumentElement();
        JSONObject json = new JSONObject();

        json.put("checkIn", reserva.getElementsByTagName("checkIn").item(0).getTextContent());
        json.put("checkOut", reserva.getElementsByTagName("checkOut").item(0).getTextContent());
        json.put("numHabitaciones", Integer.parseInt(reserva.getElementsByTagName("numHabitaciones").item(0).getTextContent()));

        JSONObject hotel = new JSONObject();
        hotel.put("id", Integer.parseInt(((Element) reserva.getElementsByTagName("hotel").item(0)).getElementsByTagName("id").item(0).getTextContent()));
        json.put("hotel", hotel);

        JSONObject persona = new JSONObject();
        persona.put("id", Integer.parseInt(((Element) reserva.getElementsByTagName("persona").item(0)).getElementsByTagName("id").item(0).getTextContent()));
        json.put("persona", persona);

        JSONObject tipoHabitacion = new JSONObject();
        tipoHabitacion.put("id", Integer.parseInt(((Element) reserva.getElementsByTagName("tipoHabitacion").item(0)).getElementsByTagName("id").item(0).getTextContent()));
        json.put("tipoHabitacion", tipoHabitacion);

        return json;
    }

    private static boolean sendToService(JSONObject json) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(ENDPOINT_URL))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.statusCode() >= 200 && response.statusCode() < 300;
        } catch (IOException | InterruptedException e) {
            System.err.println("Error HTTP: " + e.getMessage());
            return false;
        }
    }
}
