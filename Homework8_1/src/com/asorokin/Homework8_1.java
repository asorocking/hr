package com.asorokin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Homework8_1 {

    public static void main(String[] args) {
        List<String> stringList = new LimitedList<String>(10);
        List<String> tempList = new LimitedList<String>(10);
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("four");
        stringList.add("five");
        stringList.add("six");

        System.out.println("size() = " + stringList.size());

        System.out.println("element[0] = " + stringList.get(0));

        System.out.println("indexOf(eleven) = " + stringList.indexOf("eleven"));

        System.out.println("isEmpty = " + stringList.isEmpty());

        System.out.println("contains(five) = " + stringList.contains("five"));

        Iterator<String> iter = stringList.iterator();
        System.out.print("stringList by Iterator: ");
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        System.out.print("toArray(): ");
        for (int i = 0; i < stringList.size(); i++) {
            System.out.print(stringList.toArray()[i] + " ");
        }
        System.out.println();

        tempList = stringList;
        tempList.remove("three");
        System.out.print("tempList.remove(three): ");
        for (int i = 0; i < tempList.size(); i++) {
            System.out.print(tempList.get(i) + " ");
        }
        System.out.println();

        tempList = stringList;
        String temp = tempList.remove(3);
        System.out.print("tempList.remove(3): ");
        for (int i = 0; i < tempList.size(); i++) {
            System.out.print(tempList.get(i) + " ");
        }
        System.out.print("Удалили: " + temp);
        System.out.println();

        tempList = stringList.subList(1, 2);
        System.out.print("stringList.subList(1, 2): ");
        for (int i = 0; i < tempList.size(); i++) {
            System.out.print(tempList.get(i) + " ");
        }
        System.out.println();

        System.out.print("stringList: ");
        for (int i = 0; i < stringList.size(); i++) {
            System.out.print(stringList.get(i) + " ");
        }
        System.out.println();

        System.out.println("size() = " + stringList.size());
        stringList.add("twelve");
        stringList.add("twelve");
        stringList.add("twelve");
        stringList.add("twelve");
        System.out.println("size() = " + stringList.size());

        for (int i = 0; i < stringList.size(); i++) {
            System.out.print(stringList.get(i) + " ");
        }
        System.out.println();
        System.out.println("stringList.size() = " + stringList.size());
        System.out.println("stringList.lastIndexOf(twelve) = " + stringList.lastIndexOf("twelve"));

        stringList.clear();
        System.out.println("size() after clear() = " + stringList.size());

        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("four");
        stringList.add("five");
        stringList.add("six");
        System.out.println("New stringList: ");
        for (int i = 0; i < stringList.size(); i++) {
            System.out.print(stringList.get(i) + " ");
        }
        System.out.println();

        stringList.set(3, "nine");
        System.out.println("stringList after stringList.set(3, nine): ");
        for (int i = 0; i < stringList.size(); i++) {
            System.out.print(stringList.get(i) + " ");
        }
        System.out.println();

        try {
            stringList.add("one");
            stringList.add("two");
            stringList.add("three");
            stringList.add("four");
            stringList.add("five");
            stringList.add("six");
            stringList.add("one");
            stringList.add("two");
            stringList.add("three");
            stringList.add("four");
            stringList.add("five");
            stringList.add("six");
        } catch (OutOfBoundException e){
            System.out.println("OutOfArrayBounfException");
        }
        

    }
}
