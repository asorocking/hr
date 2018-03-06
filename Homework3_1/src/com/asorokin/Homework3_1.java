package com.asorokin;

import java.text.NumberFormat;

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
        System.out.println("Конструктор с именем владельца карты");
        System.out.println("Имя владельца карты: " + card2.getName());
        System.out.println("Баланс карты: " + formattedBalance);
        System.out.println();
        
        Card card3 = new Card(NAME, BALANCE);
        d = card3.getBalance();
        formattedBalance = numberFormat.format(d);    
        System.out.println("Конструктор с именем владельца карты");
        System.out.println("Имя владельца карты: " + card3.getName());
        System.out.println("Баланс карты: " + formattedBalance);
        System.out.println();
        
        d = card3.getBalance();
        formattedBalance = numberFormat.format(d);
        System.out.println("Пополнение баланса карты на " + INCREASE_AMOUNT);
        System.out.println(formattedBalance + " + " + INCREASE_AMOUNT);
        d = card3.increaseBalance(INCREASE_AMOUNT);
        formattedBalance = numberFormat.format(d);
        System.out.println("Баланс карты после пополнения: " + 
                formattedBalance);
        System.out.println();
        
        d = card3.getBalance();
        formattedBalance = numberFormat.format(d);
        System.out.println("Уменьшение баланса карты на " + DECREASE_AMOUNT);
        System.out.println(formattedBalance + " - " + DECREASE_AMOUNT);
        d = card3.decreaseBalance(DECREASE_AMOUNT);
        formattedBalance = numberFormat.format(d);
        System.out.println("Баланс карты после уменьшения: " + 
                formattedBalance);
        System.out.println();
        
        d = card3.getBalance();
        formattedBalance = numberFormat.format(d);
        System.out.println("Вывод баланса карты в другой валюте. Курс " + 
                + RATE);
        System.out.println(formattedBalance + " * " + RATE);
        d = card3.otherCurrencyBalance(RATE);
        formattedBalance = numberFormat.format(d);
        System.out.println("Баланс карты в другой валюте: " + 
                formattedBalance);
    }
    
}


