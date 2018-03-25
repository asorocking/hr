package com.asorokin;

public class Homework9_1 {

    public static void main(String[] args) {
        int[] massive = {25, 1627, -2147483648, 9999, 2147483647, 753, 1, 0, 10, 5000, 5421};
        
        sort(summDigits(massive));
        
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
}
