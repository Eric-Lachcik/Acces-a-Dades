package org.example;

import org.json.JSONObject;
import org.json.XML;

public class JSONaXML {
    public String convertirJsonAXml(JSONObject jsonObject) throws IllegalArgumentException {
        try {
            return XML.toString(jsonObject);
        } catch (Exception e) {
            throw new IllegalArgumentException("No es pot convertir a XML. ", e);
        }
    }
}
