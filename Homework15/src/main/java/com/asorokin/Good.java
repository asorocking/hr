package com.asorokin;

public class Good {

    private String goodTitle;
    private Double goodPrice;
    
    public Good(){
        
    }
    
    public Good(String goodTitle, Double goodPrice) {
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
