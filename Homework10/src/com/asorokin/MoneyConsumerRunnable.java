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
import java.util.logging.Level;
import java.util.logging.Logger;

public class MoneyConsumerRunnable implements Runnable {

    Card card;

    Random r = new Random();

    public MoneyConsumerRunnable(Card card) {
        this.card = card;
    }

    @Override
    public void run() {
        while (card.getBalance() > 0 && card.getBalance() < 1000 && card.flag) {
            synchronized (card) {
                System.out.println(Thread.currentThread().getName() + ": начинаю операцию снятия. Баланс до:" + card.getBalance());
                card.decreaseBalance();
                System.out.println(Thread.currentThread().getName() + ": баланс после завершения операции: " + card.getBalance());
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
        System.out.println(Thread.currentThread().getName() + " завершен.");
        
    }

}
