/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asorokin;

import java.util.Random;

/**
 *
 * @author sorokin
 */
public class Card {

    private int balance = 500;
    static boolean flag = true;
    private int diff = 0;

    public Card() {

    }

    Random r = new Random();

    public synchronized void increaseBalance() {
        balance += 5 + r.nextInt(6);
    }

    public synchronized void decreaseBalance() {
        diff = 5 + r.nextInt(6);

        if (balance - diff >= 0) {
            balance -= diff;
        } else {
            if (balance - 5 >= 0) {
                balance -= 5;
            }
            flag = false;
        }
            
            
            
    }

    public void setBalance(int amount) {
        balance = amount;
    }

    public int getBalance() {
        return balance;
    }
}
