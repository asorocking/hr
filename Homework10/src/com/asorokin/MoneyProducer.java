package com.asorokin;

public class MoneyProducer {
        
    public MoneyProducer(){
        
    }
    
    public void increaseBalance(Card card){
        card.setBalance(card.getBalance() + 10);
        System.out.println("Было произведено ПОПЛНЕНИЕ. Текущий баланс: " + card.getBalance());
    }
}
