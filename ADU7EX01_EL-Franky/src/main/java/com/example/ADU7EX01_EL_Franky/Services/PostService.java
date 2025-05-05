package com.example.ADU7EX01_EL_Franky.Services;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PostService {
    /**
     * Envia un JSON a un servicio web mediante una solicitud POST.
     *
     * @param json          El objeto JSON a enviar.
     * @param ENDPOINT_URL  La URL del servicio web.
     * @return true si la solicitud fue exitosa, false en caso contrario.
     */
    public static boolean sendToService(JSONObject json, String ENDPOINT_URL) {
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
