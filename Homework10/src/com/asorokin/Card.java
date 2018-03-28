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
        diff = 5 + r.nextInt(6);
        System.out.println("Баланс до операции " + balance);
        balance += r.nextInt(6);
        System.out.println("Увеличиваем на " + diff);
    }

    public synchronized void decreaseBalance() {
        diff = 5 + r.nextInt(6);
        System.out.println("Баланс до операции " + balance);
        if (balance - diff >= 0) {
            balance -= diff;
            System.out.println("Уменьшаем на " + diff);
        } else {
            System.out.println("Попытка уйти в минус: " + (balance - diff));
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
