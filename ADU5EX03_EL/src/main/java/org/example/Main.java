package org.example;
import com.mongodb.client.*;
import org.bson.Document;
import org.json.JSONObject;



public class Main {
    // Variable String de la Url del MongoDB
    private static final String Url = "mongodb+srv://user:passguord@cluster0.to9ja.mongodb.net/";
    // Variable String del nombre de la base de datos del MongoGB
    private static final String Database = "AD2025";
    // Variable String de la coleccion de donde quieres recoger tus datos
    private static final String Collection = "correccio";

    public static void main(String[] args) {
        // Iniciamos la clase Json a Xml
        JSONaXML jsonConverter = new JSONaXML();
        try {
            // Declaramos el MongoClient con la variable URL
            MongoClient mongoClient = MongoClients.create(Url);
            // Declaramos el MongoDatabase con la variable Database
            MongoDatabase database = mongoClient.getDatabase(Database);
            // Declaramos el MongoCollection con la variable Collection
            MongoCollection<Document> collection = database.getCollection(Collection);

            // Iteramos sobre la colección
            try (MongoCursor<Document> cursor = collection.find().cursor()) {
                // Mientras que haya objetos, convertimos cada uno a Xml y lo imprimimos por pantalla
                while (cursor.hasNext()) {
                    Document document = cursor.next();
                    String  jsonString = document.toJson();
                    try {
                        JSONObject jsonObject = new JSONObject(jsonString);
                        String xmlString = jsonConverter.convertirJsonAXml(jsonObject);
                        System.out.println(xmlString);

                    } catch (Exception e) {
                        System.err.println("Error: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }catch (Exception e){
                System.err.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
            // Cerramos el cliente
            mongoClient.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}