/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asorokin;

/**
 *
 * @author sorokin
 */
public class Card {
    //variables for cardholder name and card balance
    private String name;
    private double balance;
        
    //defaul constructor 
    Card(){
        name = "";
        balance = 0;
    }
    
    //constructor with one String parameter
    Card(String name){
        this.name = name;
        balance = 0;
    }
    
    //constructor with two parameters: String and double
    Card(String name, double balance){
        this.name = name;
        this.balance = balance;
    }
    
    
    //method of getting card balance
    public double getBalance() {
        return balance;
    }
    
    //method of getting cardholder name
    public String getName() {
        return name;
    }
    
    //method of increasing balance
    public double increaseBalance (double increaseAmount){
        double result = balance + increaseAmount;
        return result;
    }
    
    //method of decreasing balance
    public double decreaseBalance (double decreaseAmount){
        double result = balance - decreaseAmount;
        return result;
    }
    
    //method of change balance currency with exchange rate
    public double otherCurrencyBalance (double rate){
        double result = balance * rate;
        return result;
    }
}
