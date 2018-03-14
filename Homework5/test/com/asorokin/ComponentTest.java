/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asorokin;

import static com.asorokin.Parser.subStr;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Samsung
 */
public class ComponentTest {
    
    public ComponentTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        Component instance = new Component("root", "FileSystem", 0);
        String expResult = "root";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetParent() {
        System.out.println("getParent");
        Component instance = new Component("root", "FileSystem", 0);
        String expResult = "FileSystem";
        String result = instance.getParent();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetLevel() {
        System.out.println("getLevel");
        Component instance = new Component("root", "FileSystem", 0);
        int expResult = 0;
        int result = instance.getLevel();
        assertEquals(expResult, result);
    }
    
}
