package com.asorokin;

import java.util.Random;

public class MoneyConsumerRunnable implements Runnable {

    Card card;

    Random r = new Random();

    public MoneyConsumerRunnable(Card card) {
        this.card = card;
    }

    @Override
    public void run() {
        while (card.flag && card.getBalance() > 0) {
            card.decreaseBalance();
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        System.out.println(Thread.currentThread().getName() + " завершен.");
    }

}
