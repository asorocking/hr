package com.asorokin;

public class Card {
    private String name;
    private double balance;
        
    public Card(){
        name = "";
        balance = 0;
    }
    
    public Card(String name){
        this.name = name;
        balance = 0;
    }
    
    public Card(String name, double balance){
        this.name = name;
        this.balance = balance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    

    public String getName() {
        return name;
    }
    
    public double increaseBalance (double increaseAmount){
        double result = balance + increaseAmount;
        return result;
    }
    
    public double decreaseBalance (double decreaseAmount){
        double result = balance - decreaseAmount;
        return result;
    }
    
    public double otherCurrencyBalance (double rate){
        double result = balance * rate;
        return result;
    }
}
