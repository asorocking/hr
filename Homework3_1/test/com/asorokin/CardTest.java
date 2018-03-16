package com.asorokin;

import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest {
    
    public CardTest() {
    }

    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        Card instance = new Card("Ivan Divanov", 12.21);
        double expResult = 12.21;
        double result = instance.getBalance();
        assertEquals(expResult, result, 0.00005);
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        Card instance = new Card("Ivan Divanov");
        String expResult = "Ivan Divanov";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    @Test
    public void testIncreaseBalance() {
        System.out.println("increaseBalance");
        double increaseAmount = 10.09;
        Card instance = new Card("Ivan Divanov", 12.21);
        double expResult = 22.30;
        double result = instance.increaseBalance(increaseAmount);
        assertEquals(expResult, result, 0.00005);
    }

    @Test
    public void testDecreaseBalance() {
        System.out.println("decreaseBalance");
        double decreaseAmount = 12.21;
        Card instance = new Card("Ivan Divanov", 12.21);
        double expResult = 0.0;
        double result = instance.decreaseBalance(decreaseAmount);
        assertEquals(expResult, result, 0.00005);
    }

    @Test
    public void testOtherCurrencyBalance() {
        System.out.println("otherCurrencyBalance");
        double rate = 0.5;
        Card instance = new Card("Ivan Divanov", 12.21);
        double expResult = 6.10;
        double result = instance.otherCurrencyBalance(rate);
        assertEquals(expResult, result, 0.2);
    }
    
}
