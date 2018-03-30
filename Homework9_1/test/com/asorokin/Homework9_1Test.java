package com.asorokin;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class Homework9_1Test extends Assert {

    Homework9_1 hw9_1 = new Homework9_1();
    private int[] testData;
    private int[] expectedResult;

    public Homework9_1Test(int[] testData, int[] expectedResult) {
        this.testData = testData;
        this.expectedResult = expectedResult;
    }

    @Test
    public void testSummDigits() {
        int[] result = hw9_1.summDigits(testData);
        assertTrue(Arrays.equals(expectedResult, result));
    }
    
    @Test
    public void testSort() {
        int[] result = hw9_1.sort(testData);
        assertTrue(Arrays.equals(expectedResult, result));
    }

    @Parameterized.Parameters
    public static List<int[][]> summDigitsData() {
        return Arrays.asList(new int[][][]{
            {{25, 1627, -2147483648, 9999, 2147483647, 753, 1, 0, 10, 5000, 5421}, {7, 16, 47, 36, 46, 15, 1, 0, 1, 5, 12}},
            {{1111111111, 111111111, 11111111, 1111111, 111111, 11111, 1111, 111, 11, 1}, {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}},
            {{0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0}},
            {{5},{5}}
        });
    }
    
    @Parameterized.Parameters
    public static List<int[][]> sortData() {
        return Arrays.asList(new int[][][]{
            {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}},
            {{5, 4, 3, 2, 1}, {1, 2, 3, 4, 5}},
            {{4, 1, 2, 5, 3}, {1, 2, 3, 4, 5}},
            {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}}
        });
    }
}
