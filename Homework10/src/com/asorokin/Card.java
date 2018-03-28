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

    private static int balance = 500;
    static boolean flag = true;
    private static int diff = 0;

    public Card() {

    }

    static Random r = new Random();

    public synchronized static void increaseBalance() {
        diff = 5 + r.nextInt(6);
        balance += diff;
        System.out.println(Thread.currentThread().getName() + ": "
                + "пополнение на " + diff + ". Текущий баланс " + balance);
    }

    public synchronized static void decreaseBalance() {
        diff = 5 + r.nextInt(6);
        if (balance - diff >= 0) {
            balance -= diff;

            System.out.println(Thread.currentThread().getName() + ": "
                + "снятие " + diff + ". Текущий баланс " + balance);
        } else {
            int tmp = balance;
            balance = 0;
            System.out.println(Thread.currentThread().getName() + ": "
                + "пытался снять " + diff + ". Снял последние " + tmp 
                + ". Текущий баланс " + balance);
            flag = false;
        }

    }


    public synchronized static int getBalance() {
        return balance;
    }
}
