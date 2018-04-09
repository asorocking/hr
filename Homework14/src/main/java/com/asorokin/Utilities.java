package com.asorokin;

import java.util.Map;
import java.util.Map.Entry;

public class Utilities {

    public Utilities() {

    }

    public static String createJsonString(int id) {
        String result = "{\"userId\": 1,\n"
                + "\"id\":" + id + ",\n"
                + "\"title\": \"some title\",\n"
                + "\"body\": \"some message\"}";
        return result;
    }

    public static void printResult(Map<String, String> result) {
        for (Map.Entry<String, String> item : result.entrySet()) {
            System.out.printf("%s [%s]\n", item.getKey(), item.getValue());
        }
    }
}
