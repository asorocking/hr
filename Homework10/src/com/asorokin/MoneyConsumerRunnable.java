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
        while (card.getBalance() > 0 && card.getBalance() < 1000 && card.flag) {
            card.decreaseBalance();
            try {
                Thread.sleep(2000 + r.nextInt(3001));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " завершен.");
    }

}
//