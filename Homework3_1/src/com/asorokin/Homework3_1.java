package com.asorokin;

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

    public static void main(String[] args) {
        String name = "Ivan Divanov";
        double balance = 120.14;
        double increaseAmount = 34.58;
        double decreaseAmount = 112.80;
        double rate = 0.5;
        
        Card card1 = new Card();
        System.out.println("Конструктор по умолчанию");
        System.out.println("Имя владельца карты: " + card1.getName());
        System.out.println("Баланс карты: " + card1.getBalance());
        System.out.println();
        
        Card card2 = new Card(name);
        System.out.println("Конструктор с именем владельца карты");
        System.out.println("Имя владельца карты: " + card2.getName());
        System.out.println("Баланс карты: " + card2.getBalance());
        System.out.println();
        
        Card card3 = new Card(name, balance);
        System.out.println("Конструктор с именем владельца карты");
        System.out.println("Имя владельца карты: " + card3.getName());
        System.out.println("Баланс карты: " + card3.getBalance());
        System.out.println();
        
        System.out.println("Пополнение карты на " + increaseAmount);
        
        System.out.println(card3.getBalance() + );
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        
    }
    
}


