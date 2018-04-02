package com.asorokin;

import org.junit.Test;
import static org.junit.Assert.*;

public class ATMTest {

    final int DEBIT_CARD = 1;
    final int CREDIT_CARD = 2;
    final int INCREASE_BALANCE = 1;
    final int DECREASE_BALANCE = 2;

    public ATMTest() {
    }

    @Test
    public void testAtmWork() {
        System.out.println("atmWork");
        ATM atm = new ATM(1, 2, DEBIT_CARD, INCREASE_BALANCE);
        atm.atmWork();
    }

    @Test
    public void testAtmDebitIncrease() {
        System.out.println("atmDebitIncrease");
        double balance = 1.0;
        double amount = 1.0;
        ATM atm = new ATM(1, 1, DEBIT_CARD, INCREASE_BALANCE);
        double expResult = 2.0;
        double result = atm.atmDebitIncrease(balance, amount);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testAtmDebitDecrease() {
        System.out.println("atmDebitDecrease");
        double balance = 1.0;
        double amount = 1.0;
        ATM atm = new ATM(1, 2, DEBIT_CARD, DECREASE_BALANCE);
        double expResult = 0.0;
        double result = atm.atmDebitDecrease(balance, amount);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testNegativeAtmDebitDecrease() {
        System.out.println("atmNegativeDebitDecrease");
        double balance = 1.0;
        double amount = 2.0;
        ATM atm = new ATM(1, 2, DEBIT_CARD, DECREASE_BALANCE);
        double expResult = 1.0;
        double result = atm.atmDebitDecrease(balance, amount);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testAtmCreditIncrease() {
        System.out.println("atmCreditIncrease");
        double balance = 1.0;
        double amount = 1.0;
        ATM atm = new ATM(2, 1, CREDIT_CARD, INCREASE_BALANCE);
        double expResult = 2.0;
        double result = atm.atmCreditIncrease(balance, amount);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testNegativeAtmCreditDecrease() {
        System.out.println("atmNegativeCreditDecrease");
        double balance = 1.0;
        double amount = 2.0;
        ATM atm = new ATM(2, 2, CREDIT_CARD, DECREASE_BALANCE);
        double expResult = -1.0;
        double result = atm.atmCreditDecrease(balance, amount);
        assertEquals(expResult, result, 0.0);
    }

}
