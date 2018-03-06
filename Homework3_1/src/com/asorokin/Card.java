<<<<<<< HEAD
package com.asorokin;

public class Card {
    private String name;
    private double balance;
        
    public Card(){
=======
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
>>>>>>> 286eeca911e237c4b0b982e3d5ce11aa02f8737d
        name = "";
        balance = 0;
    }
    
<<<<<<< HEAD
    public Card(String name){
=======
    //constructor with one String parameter
    Card(String name){
>>>>>>> 286eeca911e237c4b0b982e3d5ce11aa02f8737d
        this.name = name;
        balance = 0;
    }
    
<<<<<<< HEAD
    public Card(String name, double balance){
=======
    //constructor with two parameters: String and double
    Card(String name, double balance){
>>>>>>> 286eeca911e237c4b0b982e3d5ce11aa02f8737d
        this.name = name;
        this.balance = balance;
    }
    
<<<<<<< HEAD
=======
    
    //method of getting card balance
>>>>>>> 286eeca911e237c4b0b982e3d5ce11aa02f8737d
    public double getBalance() {
        return balance;
    }
    
<<<<<<< HEAD
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
=======
    //method of getting cardholder name
>>>>>>> 286eeca911e237c4b0b982e3d5ce11aa02f8737d
    public String getName() {
        return name;
    }
    
<<<<<<< HEAD
=======
    //method of increasing balance
>>>>>>> 286eeca911e237c4b0b982e3d5ce11aa02f8737d
    public double increaseBalance (double increaseAmount){
        double result = balance + increaseAmount;
        return result;
    }
    
<<<<<<< HEAD
=======
    //method of decreasing balance
>>>>>>> 286eeca911e237c4b0b982e3d5ce11aa02f8737d
    public double decreaseBalance (double decreaseAmount){
        double result = balance - decreaseAmount;
        return result;
    }
    
<<<<<<< HEAD
=======
    //method of change balance currency with exchange rate
>>>>>>> 286eeca911e237c4b0b982e3d5ce11aa02f8737d
    public double otherCurrencyBalance (double rate){
        double result = balance * rate;
        return result;
    }
}
