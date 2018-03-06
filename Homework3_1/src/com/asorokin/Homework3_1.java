package com.asorokin;

import java.text.NumberFormat;
<<<<<<< HEAD

public class Homework3_1 {
        private static final String NAME = "Ivan Divanov";
        private static final double BALANCE = 1120.14;
        private static String formattedBalance;
        private static final double INCREASE_AMOUNT = 34.08;
        private static final double DECREASE_AMOUNT = 112.80;
        private static double RATE = 0.5;
        
    public static void main(String[] args) {
        double d;
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(true);

        Card card1 = new Card();
        System.out.println("Конструктор по умолчанию");
        System.out.println("Имя владельца карты: " + card1.getName());
        System.out.println("Баланс карты: " + card1.getBalance());
        System.out.println();
        
        Card card2 = new Card(NAME);
        d = card2.getBalance();
        formattedBalance = numberFormat.format(d);
=======
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sorokin
 */
public class Homework3_1 {
    
    //Since the data entry type was not explicitly specified, 
    //the parameters for the methods are assigned to variables.
    private static String name = "Ivan Divanov";  //cardholder name
    private static double balance = 1120.14;      //card balance
    private static String formattedBalance;       //variable for formatted card balance 
    private static double increaseAmount = 34.08; //amount of increase balance
    private static double decreaseAmount = 112.80;//amount of decrease balance
    private static double rate = 0.5;             //exchange rate 
        
    public static void main(String[] args) {
        double d; //variable for new balance amount
        
        //create instance of NumberFormat class for format double type result
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(2); //set two digits after point
        numberFormat.setGroupingUsed(true); //grouping digits

        //using default constructor
        Card card1 = new Card();
        System.out.println("Конструктор по умолчанию");
        //using method of getting cardholder name
        System.out.println("Имя владельца карты: " + card1.getName());
        //using method of getting card balance
        System.out.println("Баланс карты: " + card1.getBalance());
        System.out.println();
        
        //using constructor with one String parameter
        Card card2 = new Card(name);
        d = card2.getBalance();
        formattedBalance = numberFormat.format(d); //format balance amount
>>>>>>> 286eeca911e237c4b0b982e3d5ce11aa02f8737d
        System.out.println("Конструктор с именем владельца карты");
        System.out.println("Имя владельца карты: " + card2.getName());
        System.out.println("Баланс карты: " + formattedBalance);
        System.out.println();
        
<<<<<<< HEAD
        Card card3 = new Card(NAME, BALANCE);
=======
        //using constructor with two parameters: String and double
        Card card3 = new Card(name, balance);
>>>>>>> 286eeca911e237c4b0b982e3d5ce11aa02f8737d
        d = card3.getBalance();
        formattedBalance = numberFormat.format(d);    
        System.out.println("Конструктор с именем владельца карты");
        System.out.println("Имя владельца карты: " + card3.getName());
        System.out.println("Баланс карты: " + formattedBalance);
        System.out.println();
        
<<<<<<< HEAD
        d = card3.getBalance();
        formattedBalance = numberFormat.format(d);
        System.out.println("Пополнение баланса карты на " + INCREASE_AMOUNT);
        System.out.println(formattedBalance + " + " + INCREASE_AMOUNT);
        d = card3.increaseBalance(INCREASE_AMOUNT);
=======
        //using method of increasing balance
        d = card3.getBalance();
        formattedBalance = numberFormat.format(d);
        System.out.println("Пополнение баланса карты на " + increaseAmount);
        System.out.println(formattedBalance + " + " + increaseAmount);
        d = card3.increaseBalance(increaseAmount);
>>>>>>> 286eeca911e237c4b0b982e3d5ce11aa02f8737d
        formattedBalance = numberFormat.format(d);
        System.out.println("Баланс карты после пополнения: " + 
                formattedBalance);
        System.out.println();
        
<<<<<<< HEAD
        d = card3.getBalance();
        formattedBalance = numberFormat.format(d);
        System.out.println("Уменьшение баланса карты на " + DECREASE_AMOUNT);
        System.out.println(formattedBalance + " - " + DECREASE_AMOUNT);
        d = card3.decreaseBalance(DECREASE_AMOUNT);
=======
        //using method of decreasing balance
        d = card3.getBalance();
        formattedBalance = numberFormat.format(d);
        System.out.println("Уменьшение баланса карты на " + decreaseAmount);
        System.out.println(formattedBalance + " - " + decreaseAmount);
        d = card3.decreaseBalance(decreaseAmount);
>>>>>>> 286eeca911e237c4b0b982e3d5ce11aa02f8737d
        formattedBalance = numberFormat.format(d);
        System.out.println("Баланс карты после уменьшения: " + 
                formattedBalance);
        System.out.println();
        
<<<<<<< HEAD
        d = card3.getBalance();
        formattedBalance = numberFormat.format(d);
        System.out.println("Вывод баланса карты в другой валюте. Курс " + 
                + RATE);
        System.out.println(formattedBalance + " * " + RATE);
        d = card3.otherCurrencyBalance(RATE);
=======
        //using method of change balance currency with exchange rate
        d = card3.getBalance();
        formattedBalance = numberFormat.format(d);
        System.out.println("Вывод баланса карты в другой валюте. Курс " + 
                + rate);
        System.out.println(formattedBalance + " * " + rate);
        d = card3.otherCurrencyBalance(rate);
>>>>>>> 286eeca911e237c4b0b982e3d5ce11aa02f8737d
        formattedBalance = numberFormat.format(d);
        System.out.println("Баланс карты в другой валюте: " + 
                formattedBalance);
    }
    
}


