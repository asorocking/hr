package com.sorokin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sorokin
 */
public class ChooserData {
    public static String chooseData(String line){
        if (line.matches("\\d+")) {
            line = "int";
        } else if (line.matches("[A-z]+")) {
            line = "string";
        } else line = "other";
        
        return line;
    }
}
