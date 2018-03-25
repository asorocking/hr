package com.asorokin;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class SortTest extends Assert {

    Homework9_1 hw9_1 = new Homework9_1();
    private int[] testData;
    private int[] expectedResult;

    public SortTest(int[] testData, int[] expectedResult) {
        this.testData = testData;
        this.expectedResult = expectedResult;
    }
    
    @Test
    public void testSort() {
        int[] result = hw9_1.sort(testData);
        assertTrue(Arrays.equals(expectedResult, result));
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
