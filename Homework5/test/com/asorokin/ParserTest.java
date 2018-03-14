/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asorokin;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Samsung
 */
public class ParserTest {
    
    public ParserTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testParsePath() {
        System.out.println("parsePath");
        String realPath = "root/folder/file.txt";
        Parser.parsePath(realPath);
    }
    
}
