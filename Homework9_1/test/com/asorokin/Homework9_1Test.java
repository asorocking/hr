package com.asorokin;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Homework9_1Test extends Assert {

    private Integer[] testData;
    private Integer[] expectedResult;

    public Homework9_1Test(Integer[] testData, Integer[] expectedResult) {
        this.testData = testData;
        this.expectedResult = expectedResult;
    }

    @Test
    public void testSort() {
        Integer[] result = Homework9_1.sort(testData);
        Assert.assertArrayEquals(expectedResult, result);
    }

    @Parameterized.Parameters
    public static List<Integer[][]> sortData() {
        return Arrays.asList(new Integer[][][]{
            {{25, 1627, -2147483646, 9999, 2147483647, 753, 1, 0, 10, 5000, 5421}, 
                {0, 1, 10, 5000, 25, 5421, 753, 1627, 9999, -2147483646, 2147483647}},
            {{1111111111, 111111111, 11111111, 1111111, 111111, 11111, 1111, 111, 11, 1}, 
                {1, 11, 111, 1111, 11111, 111111, 1111111, 11111111, 111111111, 1111111111}},
            {{0, 0, 0, 0, 1, 0, 0}, 
                {0, 0, 0, 0, 0, 0, 1}},
            {{5}, 
                {5}}
        });
    }

}
