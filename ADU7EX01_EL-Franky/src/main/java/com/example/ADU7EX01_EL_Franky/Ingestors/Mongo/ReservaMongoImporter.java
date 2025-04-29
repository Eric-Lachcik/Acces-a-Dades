package com.example.ADU7EX01_EL_Franky.Ingestors.Mongo;


import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.ADU7EX01_EL_Franky.Services.PostService;
import com.mongodb.client.result.UpdateResult;

@Component
public class ReservaMongoImporter {

    // Nombre de la coleccion y url de post
    private static final String COLLECTION = "reservas";
    private static final String ENDPOINT_URL = "http://localhost:8080/reservas";

    // MongoTemplate permite interactuar con MongoDB
    @Autowired
    private MongoTemplate mongoTemplate;

    // Recogida de datos cada 120 segundos
    @Scheduled(fixedRate = 12000)
    public void importarDesdeMongo() {
        try {
            // Crea una consulta para obtener solo documentos no procesados
            Query query = new Query(Criteria.where("procesado").exists(false));

            // Obtiene todos los documentos no procesados de la colección reservas
            List<Document> documentos = mongoTemplate.find(query, Document.class, COLLECTION);

            System.out.println("Se encontraron " + documentos.size() + " reservas sin procesar");

            for (Document document : documentos) {
                // Obtiene el ID del documento
                ObjectId id = document.getObjectId("_id");

                // Convierte el documento BSON a una cadena JSON
                String jsonString = document.toJson();

                // Crea un objeto JSON a partir de la cadena
                JSONObject jsonObject = new JSONObject(jsonString);

                // Envía el JSON al endpoint del Post
                boolean success = PostService.sendToService(jsonObject, ENDPOINT_URL);
                System.out.println("Reserva enviada -> " + (success ? "correcte" : "error"));

                if (success) {
                    // Marca el documento como procesado
                    Query updateQuery = new Query(Criteria.where("_id").is(id));
                    Update update = new Update().set("procesado", true);
                    UpdateResult result = mongoTemplate.updateFirst(updateQuery, update, COLLECTION);

                    System.out.println("Documento marcado como procesado: " + result.getModifiedCount());
                }
            }
        } catch (Exception e) {
            System.err.println("Error al acceder a MongoDB: " + e.getMessage());
            e.printStackTrace();
        }
    }
}