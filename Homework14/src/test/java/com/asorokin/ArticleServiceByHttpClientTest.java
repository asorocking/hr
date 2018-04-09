package com.asorokin;

import static com.asorokin.ParserJSON.parseJSON;
import java.util.Map;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sorokin
 */
public class ArticleServiceByHttpClientTest {

    public ArticleServiceByHttpClientTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testGetJSON() {
        System.out.println("ArticleServiceByHttpClient");
        int id = 1;
        ArticleServiceByHttpClient articleServiceByHttpClient = new ArticleServiceByHttpClient();
        String expResult = "1";
        Map<String, String> json = parseJSON(articleServiceByHttpClient.getJSON(id));
        String result = json.get("Article");
        assertEquals(expResult, result);
    }
    
    @Test
    public void testUploadToServer() {
        System.out.println("ArticleServiceByHttpClient");
        int id = 101;
        ArticleServiceByHttpClient articleServiceByHttpClient = new ArticleServiceByHttpClient();
        String expResult = "101";
        Map<String, String> json = parseJSON(articleServiceByHttpClient.uploadToServer(id));
        String result = json.get("Article");
        assertEquals(expResult, result);
    }

}

