package com.asorokin;

import java.util.Arrays;

public final class Median {
    //method to find median of array of integer numbers
    public static float median(int[] array) {
        Arrays.sort(array);          
        int center = array.length / 2; 
        if (array.length%2 == 1) {   //check even or odd array lenght
            return array[center];    
        } else {
            //even array lenght, cast result of division to float 
            return (float)(array[center-1] + array[center]) / 2;
        }
    }
    
    //method to find median of array of double numbers
    public static double median(double[] array) {
        Arrays.sort(array);          
        int center = array.length / 2; 
        if (array.length%2 == 1) {
            return array[center];
        } else {
            return (array[center-1] + array[center]) / 2.0;
        }
    }
}


