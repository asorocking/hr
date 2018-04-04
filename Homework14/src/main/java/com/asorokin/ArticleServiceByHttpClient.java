package com.asorokin;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ArticleServiceByHttpClient implements ArticleService {
    
    public ArticleServiceByHttpClient(){
    
    }

    @Override
    public String getJSON(int id) {
        String result = "";
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpget = new HttpGet("https://jsonplaceholder.typicode.com/posts/" + id);
            CloseableHttpResponse response = httpclient.execute(httpget);

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            } else {
                result = "entity == null";
            }
        } catch (IOException e) {
            System.out.println("IOException " + e);
        }
        return result;
    }

    @Override
    public String uploadToServer(int id) {
        String result;
        HttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpPost httppost = new HttpPost("https://jsonplaceholder.typicode.com/posts");
            StringEntity params = new StringEntity("{\"userId\": 1,\n"
                    + "\"id\":" + id + ",\n"
                    + "\"title\": \"some title\",\n"
                    + "\"body\": \"some message\"}");
            httppost.addHeader("content-type", "application/json");
            httppost.setEntity(params);
            HttpResponse response = httpClient.execute(httppost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
                return result;
            }
        } catch (Exception ex) {
        } finally {
        }
        return null;
    }

}
