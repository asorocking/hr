package com.asorokin;

public class Card {

    private double balance;
    private double amount;

    public Card() {
    }

    public Card(double balance, double amount) {
        this.balance = balance;
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double increaseBalance(double balance, double amount) {
        double result = balance + amount;
        return result;
    }

    public double decreaseBalance(double balance, double amount) {
        double result = balance - amount;
        return result;
    }

}
