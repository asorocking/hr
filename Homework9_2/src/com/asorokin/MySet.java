/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asorokin;

import java.util.HashSet;

/**
 *
 * @author Samsung
 */
public class MySet {

    private HashSet<Integer> setA = new HashSet<Integer>();
    private HashSet<Integer> setB = new HashSet<Integer>();
    private static HashSet<Integer> setTmp = new HashSet<Integer>();

    public MySet() {

    }

    public MySet(HashSet<Integer> setA, HashSet<Integer> setB) {
        this.setA = setA;
        this.setB = setB;
    }

    public static HashSet<Integer> combine(HashSet<Integer> setA, HashSet<Integer> setB) {
        setA.addAll(setB);
        return setA;
    }

    public static HashSet<Integer> intersection(HashSet<Integer> setA, HashSet<Integer> setB) {
        setA.retainAll(setB);
        return setA;
    }

    public static HashSet<Integer> difference(HashSet<Integer> setA, HashSet<Integer> setB) {
        setA.removeAll(setB);
        return setA;
    }

    public static HashSet<Integer> symmetricDifference(HashSet<Integer> setA, HashSet<Integer> setB) {
        setTmp.addAll(setA);
        setA.removeAll(setB);
        setB.removeAll(setTmp);
        setA.addAll(setB);
        return setA;
    }
}
