package com.asorokin;

import java.util.Random;

public class Homework10 {

    public static void main(String[] args) {
        Card card = new Card();
        System.out.println("Начальный баланс: " +card.getBalance());
        Runnable mpr = new MoneyProducerRunnable(card);
        Runnable mcr = new MoneyConsumerRunnable(card);

        int i, tpAmount, tcAmount;

        Random r = new Random();

        Thread[] tp = new Thread[5];
        for (i = 0; i < (4 + r.nextInt(2)); i++) {
            tp[i] = new Thread(mpr, "MoneyProducer-" + i);
        }

        tpAmount = i;
        for (i = 0; i < tpAmount; i++) {
            tp[i].start();
        }

        Thread[] tc = new Thread[5];
        for (i = 0; i < (4 + r.nextInt(2)); i++) {
            tc[i] = new Thread(mcr, "MoneyConsumer-" + i);
        }

        tcAmount = i;
        for (i = 0; i < tcAmount; i++) {
            tc[i].start();
        }

        for (i = 0; i < tpAmount; i++) {
            try {
                tp[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (i = 0; i < tcAmount; i++) {
            try {
                tc[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("End of " + Thread.currentThread().getName());
    }

}
