package com.asorokin;

public class Homework10 {

    public static void main(String[] args) {
     
        Runnable r = new ATMRunnable();
        Thread t1 = new Thread(r, "MyThread-1");
        Thread t2 = new Thread(r, "MyThread-2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End of " + Thread.currentThread().getName());
    }
    
}
