/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sorokin
 */
public class IntValidator implements Validator{
    @Override
    public void validate(String line){
        int number = Integer.valueOf(line);
        if (number > 0 && number < 11) {
            System.out.println(number + " is valid number");
        } else {
            System.out.println(number + " is invalid number");
        }
    }
}
