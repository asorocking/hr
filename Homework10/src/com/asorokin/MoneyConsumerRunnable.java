package com.asorokin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MoneyConsumerRunnable implements Runnable {

    Card card;
    
    Random r = new Random();
    
    public MoneyConsumerRunnable(Card card) {
        this.card = card;
    }
   
    @Override
    public void run() {
        while (card.getBalance() > 0 && card.getBalance() < 1000 && card.flag) {
            card.decreaseBalance();
            System.out.println(Thread.currentThread().getName() + ": баланс после завершения операции: " + card.getBalance());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " завершен.");
        /*
        if (card.getBalance() > 0 && card.getBalance() < 1000) {
            //synchronized (this) {
                //Thread t = Thread.currentThread();
                card.decreaseBalance();
                System.out.println(Thread.currentThread().getName() + ": баланс после завершения операции: " + card.getBalance());
            //}
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            run();
        } else {
            System.out.println(Thread.currentThread().getName() + " завершен.");
        }
        */
    }

}
