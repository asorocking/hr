package com.asorokin;

public class ATM {

    private final int DEBIT_CARD = 1;
    private final int CREDIT_CARD = 2;
    private final int INCREASE_BALANCE = 1;
    private final int DECREASE_BALANCE = 2;
    private double balance;
    private double amount;
    private int cardType;
    private int operation;

    public ATM(double balance, double amount, int cardType, int operation) {
        this.balance = balance;
        this.amount = amount;
        this.cardType = cardType;
        this.operation = operation;
    }
    
    //Choose card type and operation type
    public void atmWork() {
        switch (cardType) {
            case DEBIT_CARD:
                switch (operation) {
                    case INCREASE_BALANCE:
                        atmDebitIncrease(balance, amount);
                        break;
                    case DECREASE_BALANCE:
                        atmDebitDecrease(balance, amount);
                        break;
                }
                break;
            case CREDIT_CARD:
                switch (operation) {
                    case INCREASE_BALANCE:
                        atmCreditIncrease(balance, amount);
                        break;
                    case DECREASE_BALANCE:
                        atmCreditDecrease(balance, amount);
                        break;
                }
                break;
        }
    }

    public double atmDebitIncrease(double balance, double amount) {
        DebitCard debitCard = new DebitCard();
        return debitCard.increaseBalance(balance, amount);
    }

    public double atmDebitDecrease(double balance, double amount) {
        DebitCard debitCard = new DebitCard();
        return debitCard.decreaseBalance(balance, amount);
    }

    public double atmCreditIncrease(double balance, double amount) {
        CreditCard creditCard = new CreditCard();
        return creditCard.increaseBalance(balance, amount);
    }

    public double atmCreditDecrease(double balance, double amount) {
        CreditCard creditCard = new CreditCard();
        return creditCard.decreaseBalance(balance, amount);
    }

}
