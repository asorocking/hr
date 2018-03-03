package com.asorokin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.asorokin.Homework2_2;
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
public class Homework2_2Test {
    
    public Homework2_2Test() {
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
     * Test of calculateFibonacciWhile method, of class Homework2_2.
     */
    @Test
    public void testCalculateFibonacciWhile() {
        int expResult = 21;
        int result = Homework2_2.calculateFibonacciWhile(8);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateFibonacciDoWhile method, of class Homework2_2.
     */
    @Test
    public void testCalculateFibonacciDoWhile() {
        int expResult = 21;
        int result = Homework2_2.calculateFibonacciDoWhile(8);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateFibonacciFor method, of class Homework2_2.
     */
    @Test
    public void testCalculateFibonacciFor() {
        int expResult = 21;
        int result = Homework2_2.calculateFibonacciFor(8);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateFactorialWhile method, of class Homework2_2.
     */
    @Test
    public void testCalculateFactorialWhile() {
        int expResult = 40320;
        int result = Homework2_2.calculateFactorialWhile(8);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateFactorialDoWhile method, of class Homework2_2.
     */
    @Test
    public void testCalculateFactorialDoWhile() {
        int expResult = 40320;
        int result = Homework2_2.calculateFactorialDoWhile(8);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateFactorialFor method, of class Homework2_2.
     */
    @Test
    public void testCalculateFactorialFor() {
        int expResult = 40320;
        int result = Homework2_2.calculateFactorialFor(8);
        assertEquals(expResult, result);
    }
    
}
