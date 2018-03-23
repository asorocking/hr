package com.asorokin;

import java.util.ArrayList;
import java.util.List;

class CompanyOne{
    public static final int PRICE = 200;
    
    List<Worker> companyOneWorkerList = new ArrayList<Worker>();
    
    public CompanyOne(){
    }
    
    public CompanyOne(Worker worker){
        companyOneWorkerList.add(worker);
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
