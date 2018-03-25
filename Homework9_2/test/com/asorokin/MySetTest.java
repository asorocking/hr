/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asorokin;

import java.util.HashSet;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Samsung
 */
public class MySetTest {

    HashSet<Integer> setA = new HashSet<Integer>();
    HashSet<Integer> setB = new HashSet<Integer>();
    HashSet<Integer> expectedResult = new HashSet<Integer>();

    public MySetTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testCombine() {
        System.out.println("combine");
        setA.add(1);
        setA.add(2);
        setA.add(4);
        setB.add(3);
        setB.add(4);
        setB.add(5);
        setB.add(6);
        expectedResult.add(1);
        expectedResult.add(2);
        expectedResult.add(3);
        expectedResult.add(4);
        expectedResult.add(5);
        expectedResult.add(6);

        HashSet<Integer> result = MySet.combine(setA, setB);
        assertTrue(expectedResult.equals(result));
    }

    @Test
    public void testIntersection() {
        System.out.println("intersection");
        setA.add(1);
        setA.add(2);
        setA.add(4);
        setB.add(3);
        setB.add(4);
        setB.add(5);
        setB.add(2);
        expectedResult.add(2);
        expectedResult.add(4);

        HashSet<Integer> result = MySet.intersection(setA, setB);
        assertTrue(expectedResult.equals(result));
    }

    @Test
    public void testDifference() {
        System.out.println("difference");
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.add(4);
        setB.add(3);
        setB.add(4);
        setB.add(5);
        expectedResult.add(1);
        expectedResult.add(2);

        HashSet<Integer> result = MySet.difference(setA, setB);
        assertTrue(expectedResult.equals(result));
    }

    @Test
    public void testSymmetricDifference() {
        System.out.println("symmetricDifference");
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.add(4);
        setB.add(3);
        setB.add(4);
        setB.add(5);
        setB.add(6);
        expectedResult.add(1);
        expectedResult.add(2);
        expectedResult.add(5);
        expectedResult.add(6);

        HashSet<Integer> result = MySet.symmetricDifference(setA, setB);
        assertTrue(expectedResult.equals(result));
    }

}
