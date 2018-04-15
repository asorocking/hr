package com.asorokin;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class ParserJSON {

    public static Map<String, String> parseJSON(String resultJson) {
        try {
            // конвертируем строку с Json в JSONObject для дальнейшего его парсинга
            JSONObject placeholderJsonObject = (JSONObject) JSONValue.parse(resultJson);

            Map<String, String> json = new LinkedHashMap<>();
            json.put("Article", placeholderJsonObject.get("id").toString());
            json.put("User", placeholderJsonObject.get("userId").toString()); 
            json.put("Title", placeholderJsonObject.get("title").toString()); 
            json.put("Message", placeholderJsonObject.get("body").toString()); 
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
