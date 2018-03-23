package com.asorokin;

import java.util.ArrayList;
import java.util.List;

class CompanyTwo{
    private static final int PRICE = 200;
    private static final String companyName = "COMPANY TWO";
    
    List<Worker> companyTwoWorkerList = new ArrayList<Worker>();
    
    public CompanyTwo(){
    }
    
    public CompanyTwo(Worker worker){
        companyTwoWorkerList.add(worker);
    }
    
    public String getCompanyName(){
        return companyName;
    }
    
    public int getPrice() {
        return PRICE;
    }    
    
    public void print(List<CompanyTwo> companyTwoList) {
        System.out.println("Company Two. Our price is " + PRICE + "$. We have:");
        for (Worker ctwl : companyTwoWorkerList) {
            System.out.println(ctwl);
        }
    }
}
