package com.asorokin;

import java.util.ArrayList;
import java.util.List;

class CompanyOne{
    private static final int PRICE = 100;
    private static final String companyName = "COMPANY ONE";
    
    List<Worker> companyOneWorkerList = new ArrayList<Worker>();
    
    public CompanyOne(){
    }
           
    public CompanyOne(Worker worker){
        companyOneWorkerList.add(worker);
    }
    
    public String getCompanyName(){
        return companyName;
    }
    
    public int getPrice() {
        return PRICE;
    }    
    
    public void print(List<CompanyOne> companyOneList) {
        System.out.println("Company One. Our price is " + PRICE + "$. We have:");
        for (Worker cowl : companyOneWorkerList) {
            System.out.println(cowl);
        }
    }
}
