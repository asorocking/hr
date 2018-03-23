/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asorokin;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sorokin
 */
public class Chooser {
    
    List<Require> requireList;
    List<Require> companyList;

    public Chooser() {
    }
    
    public Chooser(List<Require> requireList, List<Require> companyList) {
        this.requireList = requireList;
        this.companyList = companyList;
    }
    
    public boolean choose(List<Require> requireList, List<Require> companyList){
        boolean result = true;
        
        for (int i = 0; i < 5; i++){
            if (requireList.get(i).requireWorkerQuantity > companyList.get(i).requireWorkerQuantity){
                result = false;
                break;
            }
        }
        
        return result;
    }
    
}
