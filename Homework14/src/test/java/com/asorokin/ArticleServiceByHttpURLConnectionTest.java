package com.asorokin;

import static com.asorokin.ParserJSON.parseJSON;
import java.util.Map;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArticleServiceByHttpURLConnectionTest {

    public ArticleServiceByHttpURLConnectionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testGetJSON() {
        System.out.println("ArticleServiceByHttpURLConnection");
        int id = 1;
        ArticleServiceByHttpURLConnection articleServiceByHttpURLConnection = new ArticleServiceByHttpURLConnection();
        String expResult = "1";
        Map<String, String> json = parseJSON(articleServiceByHttpURLConnection.getJSON(id));
        String result = json.get("Article");
        assertEquals(expResult, result);
    }

}
