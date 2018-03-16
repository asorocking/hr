/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sorokin
 */
public class StringValidator implements Validator{
    @Override
    public void validate(String line){
        if (line.matches("^([A-Z][a-z]+)")) {
            System.out.println(line + " is valid line");
        } else {
        System.out.println(line + " is invalid line");
        }
    }
}
