package com.asorokin;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int id;
    private int userID;
    private float totalPrice;
    public static List<Order> orders = new ArrayList<Order>();

    public Order() {

    }

    public Order(int userID, float totalPrice) {
        this.userID = userID;
        this.totalPrice = (float) totalPrice;
    }

    public Order(int id, int userID, float totalPrice) {
        this.id = id;
        this.userID = userID;
        this.totalPrice = totalPrice;
    }

    public int getID() {
        return id;
    }

    public int getUserID() {
        return userID;
    }

    public float getTotalPrice() {
        return totalPrice;
    }
}
