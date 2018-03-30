package com.asorokin;

import java.util.Arrays;
import java.util.Comparator;

public class Homework9_1 implements Comparator<Integer> {

    public static void main(String[] args) {
        Integer[] massive = {25, 1627, -2147483646, 9999, 2147483647, 753, 1, 0, 10, 5000, 5421};

        sort(massive);

        for (int i : massive) {
            System.out.print(i + " ");
        }
    }
    public static int multy(int a) {
        return 10 + a;
    }
    public static Integer[] sort(Integer[] massive) {
        Arrays.sort(massive, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                Integer summ1 = 0;
                Integer summ2 = 0;
                if (a < 0) {
                    a *= -1;
                }
                if (b < 0) {
                    b *= -1;
                }
                for (int d = 1000000000; d >= 1; d /= 10) {
                    if (a / d != 0) {
                        summ1 += a / d;
                        a %= d;
                    }
                    if (b / d != 0) {
                        summ2 += b / d;
                        b %= d;
                    }
                }
                return summ1.compareTo(summ2);
            }
        });
        return massive;
    }

    @Override
    public int compare(Integer a, Integer b) {
        return a.compareTo(b);
    }
}
