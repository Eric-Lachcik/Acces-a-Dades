package org.example;

import org.json.JSONObject;
import org.json.XML;

public class JSONaXML {
    public String convertirJsonAXml(JSONObject jsonObject) throws IllegalArgumentException {
        if (jsonObject == null || jsonObject.isEmpty()) {
            throw new IllegalArgumentException("El objeto JSON está vacío o es nulo.");
        }

        try {
            return XML.toString(jsonObject, 2);
        } catch (Exception e) {
            throw new IllegalArgumentException("No se puede convertir a XML. ", e);
        }
    }
}
