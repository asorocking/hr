package com.asorokin;

public class OutOfBoundException extends ArrayIndexOutOfBoundsException{
    int triesOutOfBound = 0;
    public OutOfBoundException() {
        triesOutOfBound++; 
    }
    
}