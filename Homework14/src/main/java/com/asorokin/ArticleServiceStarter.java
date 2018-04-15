package com.asorokin;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ArticleServiceStarter {

    public static void main(String[] args) throws IOException, Exception {
       
        int method = Integer.valueOf(args[0]);
        int id = Integer.valueOf(args[1]);

        ArticleService articleService = null;

        switch (method) {
            case 1:
                articleService = new ArticleServiceByHttpURLConnection();
                break;
            case 2:
                articleService = new ArticleServiceByHttpClient();
                break;
        }
        
        Map<String, String> result = new LinkedHashMap<>();
        if (id > 0 && id < 101) {
            String resultJson = articleService.getJSON(id);
            result = ParserJSON.parseJSON(resultJson);
        } else {
            String resultJson = articleService.uploadToServer(id);
            result = ParserJSON.parseJSON(resultJson);
        }
        
        Utilities.printResult(result);
    }

}


