package com.asorokin;

import java.util.ArrayList;
import java.util.List;

class CompanyFour{
    private static final int PRICE = 50;
    private static final String companyName = "COMPANY FOUR";
    
    List<Worker> companyFourWorkerList = new ArrayList<Worker>();
    
    public CompanyFour(){
    }
    
    public CompanyFour(Worker worker){
        companyFourWorkerList.add(worker);
    }
    
    public String getCompanyName(){
        return companyName;
    }
    
    public int getPrice() {
        return PRICE;
    }    
    
    public void print(List<CompanyFour> companyFourList) {
        System.out.println("Company Four. Our price is " + PRICE + "$. We have:");
        for (Worker ctwl : companyFourWorkerList) {
            System.out.println(ctwl);
        }
    }
}
