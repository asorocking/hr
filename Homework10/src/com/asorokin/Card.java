package com.asorokin;

public class Card {

    private int balance = 500;

    public Card() {

    }

    public int setBalance(int amount) {
        balance = amount;
        return balance;
    }

    public int getBalance() {
        return balance;
    }
}
