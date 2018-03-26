package com.asorokin;

public class Homework10 {

    public static void main(String[] args) {
        Card card = new Card();
        Runnable mpr = new MoneyProducerRunnable(card);
        Runnable mcr = new MoneyConsumerRunnable(card);
        
        Thread t1 = new Thread(mcr, "MoneyConsumer-1");
        Thread t2 = new Thread(mcr, "MoneyConsumer-2");
        Thread t3 = new Thread(mcr, "MoneyConsumer-3");
        Thread t4 = new Thread(mpr, "MoneyProducer-1");
        Thread t5 = new Thread(mpr, "MoneyProducer-2");
        Thread t6 = new Thread(mpr, "MoneyProducer-3");
        Thread t7 = new Thread(mpr, "MoneyProducer-4");
        Thread t8 = new Thread(mpr, "MoneyProducer-5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
            t8.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End of " + Thread.currentThread().getName());
    }
    
}
