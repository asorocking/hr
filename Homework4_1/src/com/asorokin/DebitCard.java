package com.asorokin;

public class DebitCard extends Card{
    public DebitCard(){
        super();
    }
        
    @Override
    public double decreaseBalance (double balance, double amount){
        double result = balance - amount;
        if (result < 0) {
            System.out.println("На карте недостаточно средств. Отмена. ");
            //If result is negative then will return old balance
            return balance;
        } else {
            setBalance(result);
            return result;
        }
    }
    
}
