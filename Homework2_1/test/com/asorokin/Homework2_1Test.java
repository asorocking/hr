package com.asorokin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sorokin
 */
public class Homework2_1Test {
    
    public Homework2_1Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of calculate method, of class Homework2_1.
     */
    @Test 
    public void testCalculate() {
        double expResult = 19.739208802178716;
        double result = Homework2_1.calculate(2, 2, 2.0, 2.0);
        assertEquals(expResult, result, 0.0005);
    }
    
}
