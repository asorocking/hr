/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


/**
 *
 * @author Samsung
 */


public class TextToolsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

  
    @Test
    public void testPrepareTextFalse() {
        System.out.println("prepareText");
        String text = ",qwerty'";
        String expResult = ",qwerty";
        String result = TextTools.prepareText(text);
        assertFalse(expResult.equals(result));
    }

    @Test
    public void testSplitText() {
        System.out.println("splitText");
        String text = "london is the capital";
        List<String> words = new ArrayList<String>();
        words.add("london");
        words.add("is");
        words.add("the");
        words.add("capital");
        List<String> expResult = words;
        List<String> result = TextTools.splitText(text);
        assertEquals(expResult, result);
    }

    @Test
    public void testDeleteRepeatsFalse() {
        System.out.println("deleteRepeats");
        List<String> words = new ArrayList<String>();
        words.add("angels");
        words.add("crazy");
        words.add("angels");
        List<String> expResult = new ArrayList<String>();
        expResult.add("crazy");
        expResult.add("angels");
        List<String> result = TextTools.deleteRepeats(words);
        assertFalse(expResult == result);
    }
    
    @Test
    public void testDeleteRepeatsCrazyCrazyAngels() {
        System.out.println("deleteRepeats");
        List<String> words = new ArrayList<String>();
        words.add("crazy");
        words.add("crazy");
        words.add("angels");
        List<String> expResult = new ArrayList<String>();
        expResult.add("crazy");
        expResult.add("angels");
        List<String> result = TextTools.deleteRepeats(words);
        assertEquals(expResult, result);
    }
    
}
