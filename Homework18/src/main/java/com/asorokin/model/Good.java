package com.asorokin.model;

import java.util.ArrayList;
import java.util.List;

public class Good {

    private int id;
    private String title;
    private float price;
    public static List<Good> goods = new ArrayList<Good>();

    public Good() {

    }

    public Good(String title, float price) {
        this.title = title;
        this.price = price;
    }

    public Good(int id, String title, float price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public int getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice() {
        return price;
    }

}
