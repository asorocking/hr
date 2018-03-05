/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asorokin;

import java.util.Arrays;

/**
 *
 * @author sorokin
 */
public final class Median {
    
    public static float median(int[] array) {
        Arrays.sort(array);
        int center = array.length/2;
        if (array.length%2 == 1) {
            return array[center];
        } else {
            return (float)(array[center-1] + array[center]) / 2;
        }
    }
    
    public static double median(double[] array) {
        Arrays.sort(array);
        int center = array.length/2;
        if (array.length%2 == 1) {
            return array[center];
        } else {
            return (array[center-1] + array[center]) / 2.0;
        }
    }
}