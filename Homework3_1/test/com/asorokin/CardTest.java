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
public class CardTest {
    
    public CardTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        Card instance = new Card("Ivan Divanov", 12.21);
        double expResult = 12.21;
        double result = instance.getBalance();
        assertEquals(expResult, result, 0.00005);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        Card instance = new Card("Ivan Divanov");
        String expResult = "Ivan Divanov";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testIncreaseBalance() {
        System.out.println("increaseBalance");
        double increaseAmount = 10.09;
        Card instance = new Card("Ivan Divanov", 12.21);
        double expResult = 22.30;
        double result = instance.increaseBalance(increaseAmount);
        assertEquals(expResult, result, 0.00005);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testDecreaseBalance() {
        System.out.println("decreaseBalance");
        double decreaseAmount = 12.21;
        Card instance = new Card("Ivan Divanov", 12.21);
        double expResult = 0.0;
        double result = instance.decreaseBalance(decreaseAmount);
        assertEquals(expResult, result, 0.00005);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testOtherCurrencyBalance() {
        System.out.println("otherCurrencyBalance");
        double rate = 0.5;
        Card instance = new Card("Ivan Divanov", 12.21);
        double expResult = 6.10;
        double result = instance.otherCurrencyBalance(rate);
        assertEquals(expResult, result, 0.2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
