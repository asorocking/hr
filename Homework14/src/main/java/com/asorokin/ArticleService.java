package com.asorokin;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.JSONException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.cookie.CookiePolicy;

public class ArticleService {

    /* куда будем подключаться */
    static final String serverIP = "https://jsonplaceholder.typicode.com/posts/1";

    public static void main(String[] args) throws IOException, JSONException {
        System.out.println("Выберите метод: 1 - Абы как. 2 - HttpClient");
        Scanner sc = new Scanner(System.in);
        int method = sc.nextInt();
        System.out.println("Введите id публикации:");
        sc = new Scanner(System.in);
        int id = sc.nextInt();

        switch (method) {
            case 1:
                if (id > 0 && id < 101) {
                    String resultJson = getJSON(id);
                    parseCurrentJson(resultJson);
                } else {
                    uploadToServer(id);
                }
                break;
            case 2:
                break;
            default:
                System.out.println("1 or 2");
        }

    }

    public static void httpClientTool(int id) {
        HttpClient httpClient = new HttpClient();

        GetMethod getMethod = new GetMethod("https://jsonplaceholder.typicode.com/posts/" + id);

        int result = httpClient.executeMethod(getMethod);
        
        if (result == HttpStatus.SC_OK) {
            // Выводим страницу на экран
            System.out.println(getMethod.getResponseBodyAsString());
        } else {
            System.out.println("А страничка-то и не загрузилась!!!");
        }
    }

    private static void uploadToServer(int id) throws IOException, JSONException {
        try {

            URL url = new URL("https://jsonplaceholder.typicode.com/posts");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String input = "{\"userId\": 1,\n"
                    + "\"id\":" + id + ",\n"
                    + "\"title\": \"some title\",\n"
                    + "\"body\": \"some message\"}";

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    public static String getJSON(int id) {

        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/" + id);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-length", "0");
            con.setConnectTimeout(30000);

            con.connect();

            int resp = con.getResponseCode();
            if (resp == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                    sb.append("\n");
                }
                System.out.println(sb);
                br.close();

                return sb.toString();
            } else {
                System.out.println("RESP. Ответ сервера: " + resp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void parseCurrentJson(String resultJson) {
        try {
            // конвертируем строку с Json в JSONObject для дальнейшего его парсинга
            JSONObject placeholderJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);

            //Article [1]: User [1] Title [ “some title”] Message [“some message”]
            System.out.print("Article [" + placeholderJsonObject.get("id")
                    + "]: User [" + placeholderJsonObject.get("userId")
                    + "] Title [" + placeholderJsonObject.get("title")
                    + "] Message [" + placeholderJsonObject.get("body") + "]");

        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }

}
