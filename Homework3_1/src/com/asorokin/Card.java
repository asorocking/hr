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
    private String name;
    private double balance;
        
    Card(){
        name = "";
        balance = 0;
    }
    
    Card(String name){
        this.name = name;
        balance = 0;
    }
    
    Card(String name, double balance){
        this.name = name;
        this.balance = balance;
    }
    
    public double getBalance() {
        return balance;
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
    
    
    //calculate((double)a);
}
