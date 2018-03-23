package com.asorokin;

import java.util.ArrayList;
import java.util.List;

class CompanyThree{
    private static final int PRICE = 300;
    private static final String companyName = "COMPANY THREE";
    
    List<Worker> companyThreeWorkerList = new ArrayList<Worker>();
    
    public CompanyThree(){
    }
    
    public CompanyThree(Worker worker){
        companyThreeWorkerList.add(worker);
    }
    
    public String getCompanyName(){
        return companyName;
    }
    
    public int getPrice() {
        return PRICE;
    }    
    
    public void print(List<CompanyThree> companyThreeList) {
        System.out.println("Company Three. Our price is " + PRICE + "$. We have:");
        for (Worker ctwl : companyThreeWorkerList) {
            System.out.println(ctwl);
        }
    }
}
