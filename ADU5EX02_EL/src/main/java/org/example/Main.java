package org.example;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try {
            // Leemos el fichero XML original.
            ClassLoader classLoader = Main.class.getClassLoader();
            // Nombre del fichero.
            String xml = "input.xml";
            String xmlFilePath = Paths.get(classLoader.getResource(xml).toURI()).toString();
            String xmlContent = Files.readString(Paths.get(xmlFilePath));
            System.out.println("Contingut del fitxer XML original:");
            System.out.println(xmlContent);

            // Convertimos de XML a JSON.
            XMLaJSON xml2Json = new XMLaJSON();
            JSONObject jsonObject = xml2Json.convertirXmlAJson(xmlContent);

            // Guardamos el Json en un nuevo fichero.
            String jsonFilePath = "output.json";
            Files.writeString(Paths.get(jsonFilePath), jsonObject.toString(4));
            System.out.println("\nJSON generat:");
            System.out.println(jsonObject.toString(4));

            // Leemos el fichero Json que hemos creado.
            String jsonContent = Files.readString(Paths.get(jsonFilePath));

            // Convertimos de Json a Xml.
            JSONaXML json2Xml = new JSONaXML();
            String convertedXml = json2Xml.convertirJsonAXml(new JSONObject(jsonContent));

            // Guardamos el Xml en un fichero nuevo.
            String convertedXmlFilePath = "converted.xml";
            Files.writeString(Paths.get(convertedXmlFilePath), convertedXml);
            System.out.println("\nXML convertit des del JSON:");
            System.out.println(convertedXml);
        } catch (IOException e) {
            System.err.println("Error durant la lectura o escriptura de fitxers: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error de conversió: " + e.getMessage());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }
}