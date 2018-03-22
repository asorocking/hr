package com.asorokin;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class LimitedListTest {

    List<String> stringList = new LimitedList<>(10);
    List<String> tempList = new LimitedList<>(10);

    public LimitedListTest() {

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @Before
    public void setUp() {
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("four");
        stringList.add("five");
        stringList.add("six");

    }

    @Test
    public void testGet() {
        System.out.println("get");
        int index = 3;

        Object expResult = "four";
        String result = stringList.get(index);

        assertEquals(expResult, result);
    }

    @Test(expected = OutOfBoundException.class)
    public void testGet_Fail() {
        System.out.println("get Fail");
        int index = 10;

        stringList.get(index);
    }

    @Test
    public void testAdd_GenericType() {
        System.out.println("add(E)");

        boolean expResult = true;
        boolean result = stringList.add("Something");

        assertEquals(expResult, result);
    }

    @Test(expected = OutOfBoundException.class)
    public void testAdd_GenericType_Fail() {
        System.out.println("add(E) Fail");
        stringList.add("test");
        stringList.add("test");
        stringList.add("test");
        stringList.add("test");

        stringList.add("Something");
    }

    @Test
    public void testSize() {
        System.out.println("size");

        int expResult = 6;
        int result = stringList.size();

        assertEquals(expResult, result);
    }

    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");

        boolean expResult = false;
        boolean result = stringList.isEmpty();

        assertEquals(expResult, result);
    }

    @Test
    public void testIndexOf_ExistElement() {
        System.out.println("indexOf ExistElement");

        int expResult = 0;
        int result = stringList.indexOf("one");

        assertEquals(expResult, result);
    }

    @Test
    public void testIndexOf_NotExistElement() {
        System.out.println("indexOf NotExistElement");

        int expResult = -1;
        int result = stringList.indexOf("eleven");

        assertEquals(expResult, result);
    }

    @Test
    public void testContains_True() {
        System.out.println("contains True");

        boolean expResult = true;
        boolean result = stringList.contains("three");

        assertEquals(expResult, result);
    }

    @Test
    public void testContains_False() {
        System.out.println("contains False");

        boolean expResult = false;
        boolean result = stringList.contains("eleven");

        assertEquals(expResult, result);
    }

    @Test
    public void testRemove_Object_True() {
        System.out.println("remove Object True");

        boolean expResult = true;
        boolean result = stringList.remove("one");
        assertEquals(expResult, result);
    }

    @Test
    public void testRemove_Object_False() {
        System.out.println("remove Object False");

        boolean expResult = false;
        boolean result = stringList.remove("eleven");
        assertEquals(expResult, result);
    }

    @Test
    public void testClear() {
        System.out.println("clear");
        stringList.clear();

        int expResult = 0;
        int result = stringList.size();
        assertEquals(expResult, result);
    }

    @Test(expected = OutOfBoundException.class)
    public void testRemove_int_Fail() {
        System.out.println("remove int Fail");
        int index = 10;

        stringList.remove(index);
    }

}
