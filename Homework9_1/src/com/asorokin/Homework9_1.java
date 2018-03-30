package com.asorokin;

import java.util.Arrays;
import java.util.Comparator;

public class Homework9_1 implements Comparator<Integer> {

    public static void main(String[] args) {
        Integer[] massive = {25, 1627, -2147483648, 9999, 2147483647, 753, 1, 0, 10, 5000, 5421};
        int[] temp = summDigits((int[]) massive);
        //https://habrahabr.ru/post/329498/
        for (int i = 0; i < temp.length; i++){
            System.out.print(temp[i] + " ");
        }
        
        Integer[] summ = null;
        for (int i = 0; i < temp.length; i++){
            summ[i] = (Integer) temp[i];
            System.out.print(temp[i] + " ");
            System.out.print(summ[i] + " ");
        }
        Arrays.sort(summ, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
 
        for (int i : summ)
            System.out.print(i + " ");
        /*
        Integer[] data = {25, 1627, -2147483648, 9999, 2147483647, 753, 1, 0, 10, 5000, 5421};
        
        Arrays.sort(data, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                int summ1 = 0;
                int summ2 = 0;
                for (int d = 1000000000; d >= 1; d /= 10) {
                    if (o1 / d != 0) {
                        summ1 += o1 / d;
                        o1 %= d;
                    }
                    if (o2 / d != 0) {
                        summ2 += o2 / d;
                        o2 %= d;
                    }
                }
                if (summ1 < 0) {
                    summ1 *= -1;
                }
                o1 = (Integer) summ1;
                if (summ2 < 0) {
                    summ2 *= -1;
                }
                o2 = (Integer) summ2;
                return o1.compareTo(o2);
            }

            // return o1.compareTo(o2);
        }
        );
        
        System.out.println(Arrays.toString(data));
        */
    }

    
    public static int[] summDigits(int[] massive) {
        int[] summ = new int[massive.length];

        for (int i = 0; i < massive.length; i++) {
            for (int d = 1000000000; d >= 1; d /= 10) {
                if (massive[i] / d != 0) {
                    summ[i] += massive[i] / d;
                    massive[i] %= d;
                }
            }
            if (summ[i] < 0) {
                summ[i] *= -1;
            }
            System.out.print(summ[i] + ", ");
        }
        System.out.println();
        return summ;
    }
    

 /*
    public static int[] sort(int[] summ){
        for (int i = 0; i < summ.length; i++) {
            for (int j = i + 1; j < summ.length; j++) {
                if (summ[i] > summ[j]) {
                    int tmp = summ[i];
                    summ[i] = summ[j];
                    summ[j] = tmp;
                }
            }
            System.out.print(summ[i] + ", ");
        }
        return summ;
    }
     */
    @Override
    public int compare(Integer a, Integer b) {
        return a.compareTo(b);
    }
}
