package org.example;

import org.json.JSONObject;
import org.json.XML;

public class XMLaJSON {
    public JSONObject convertirXmlAJson(String xmlString) throws IllegalArgumentException {
        try {
            return XML.toJSONObject(xmlString);
        } catch (Exception e) {
            throw new IllegalArgumentException("No és un XML vàlid. ", e);
        }
    }
}
