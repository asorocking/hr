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
        private static String name = "Ivan Divanov";
        private static double balance = 1120.14;
        private static String formattedBalance;
        private static double increaseAmount = 34.08;
        private static double decreaseAmount = 112.80;
        private static double rate = 0.5;
        
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
        
        Card card2 = new Card(name);
        d = card2.getBalance();
        formattedBalance = numberFormat.format(d);
        System.out.println("Конструктор с именем владельца карты");
        System.out.println("Имя владельца карты: " + card2.getName());
        System.out.println("Баланс карты: " + formattedBalance);
        System.out.println();
        
        Card card3 = new Card(name, balance);
        d = card3.getBalance();
        formattedBalance = numberFormat.format(d);    
        System.out.println("Конструктор с именем владельца карты");
        System.out.println("Имя владельца карты: " + card3.getName());
        System.out.println("Баланс карты: " + formattedBalance);
        System.out.println();
        
        d = card3.getBalance();
        formattedBalance = numberFormat.format(d);
        System.out.println("Пополнение баланса карты на " + increaseAmount);
        System.out.println(formattedBalance + " + " + increaseAmount);
        d = card3.increaseBalance(increaseAmount);
        formattedBalance = numberFormat.format(d);
        System.out.println("Баланс карты после пополнения: " + 
                formattedBalance);
        System.out.println();
        
        d = card3.getBalance();
        formattedBalance = numberFormat.format(d);
        System.out.println("Уменьшение баланса карты на " + decreaseAmount);
        System.out.println(formattedBalance + " - " + decreaseAmount);
        d = card3.decreaseBalance(decreaseAmount);
        formattedBalance = numberFormat.format(d);
        System.out.println("Баланс карты после уменьшения: " + 
                formattedBalance);
        System.out.println();
        
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


