/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asorokin;

public class Good
{
    private String goodTitle;
    private Double goodPrice;
    public Good(){
        
    }
    public Good(String goodTitle, Double goodPrice){    
        this.goodTitle = goodTitle;
        this.goodPrice = goodPrice;
    }
    
    public String getGoodTitle(){
        return goodTitle;
    }
    
    public Double getGoodPrice(){
        return goodPrice;
    }
}