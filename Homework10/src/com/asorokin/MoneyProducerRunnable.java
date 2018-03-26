package com.asorokin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MoneyProducerRunnable implements Runnable {

    Card card;

    public MoneyProducerRunnable(Card card) {
        this.card = card;
    }

    public void setCard(Card card) {
        this.card = card;
        run();
    }

    @Override
    public void run() {

        int balance = card.getBalance();
        if (balance > 0 && balance <= 990) {
            synchronized (this) {
                Thread t = Thread.currentThread();
                card.setBalance(balance + 10);
                System.out.println(t.getName() + ": баланс после завершения операции: " + card.getBalance());
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            run();
        } else {
            System.out.println(Thread.currentThread().getName() + " завершен.");
        }

    }
}
