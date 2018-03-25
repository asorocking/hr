package com.asorokin;


public class ATMRunnable implements Runnable {
    private int n = 10;
    
    public void run(){
        if (n >= 10){
            Thread t = Thread.currentThread();
            System.out.println("running: " + t.getName());
            for (int x = n; x >= 0; x--)
                System.out.println("x: " + x + " <--at " + t.getName());
            try {
                System.out.println(t.getName() + "\nis sleeping\n");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t.getName() + "\nwake-up\n");
            n--;
            System.out.println("now n = " + n);
            run();
        } else {
            System.out.println(Thread.currentThread().getName() + " is over here");
        }
    }
}
