package com.asorokin;

import java.text.NumberFormat;
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
        System.out.println("Конструктор с именем владельца карты");
        System.out.println("Имя владельца карты: " + card2.getName());
        System.out.println("Баланс карты: " + formattedBalance);
        System.out.println();
        
        //using constructor with two parameters: String and double
        Card card3 = new Card(name, balance);
        d = card3.getBalance();
        formattedBalance = numberFormat.format(d);    
        System.out.println("Конструктор с именем владельца карты");
        System.out.println("Имя владельца карты: " + card3.getName());
        System.out.println("Баланс карты: " + formattedBalance);
        System.out.println();
        
        //using method of increasing balance
        d = card3.getBalance();
        formattedBalance = numberFormat.format(d);
        System.out.println("Пополнение баланса карты на " + increaseAmount);
        System.out.println(formattedBalance + " + " + increaseAmount);
        d = card3.increaseBalance(increaseAmount);
        formattedBalance = numberFormat.format(d);
        System.out.println("Баланс карты после пополнения: " + 
                formattedBalance);
        System.out.println();
        
        //using method of decreasing balance
        d = card3.getBalance();
        formattedBalance = numberFormat.format(d);
        System.out.println("Уменьшение баланса карты на " + decreaseAmount);
        System.out.println(formattedBalance + " - " + decreaseAmount);
        d = card3.decreaseBalance(decreaseAmount);
        formattedBalance = numberFormat.format(d);
        System.out.println("Баланс карты после уменьшения: " + 
                formattedBalance);
        System.out.println();
        
        //using method of change balance currency with exchange rate
        d = card3.getBalance();
        formattedBalance = numberFormat.format(d);
        System.out.println("Вывод баланса карты в другой валюте. Курс " + 
                + rate);
        System.out.println(formattedBalance + " * " + rate);
        d = card3.otherCurrencyBalance(rate);
        formattedBalance = numberFormat.format(d);
        System.out.println("Баланс карты в другой валюте: " + 
                formattedBalance);
    }
    
}


