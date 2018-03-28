package com.asorokin;

import java.util.Random;

public class MoneyProducerRunnable implements Runnable {

    Card card;

    Random r = new Random();

    public MoneyProducerRunnable(Card card) {
        this.card = card;
    }

    @Override
    public void run() {
        while (card.flag && card.getBalance() <= 1000) {
            card.increaseBalance();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " завершен.");
    }
}
