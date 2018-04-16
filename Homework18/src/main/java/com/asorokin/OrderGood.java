package com.asorokin;

import java.util.ArrayList;
import java.util.List;


public class OrderGood {
       
    private int id;
    private int orderID;
    private int goodID;
    //public static List<OrderGood> users = new ArrayList<OrderGood>();
    

    public OrderGood() {

    }

    public OrderGood(int orderID, int goodID) {
        this.orderID = orderID;
        this.goodID = goodID;
    }

    public OrderGood(int id, int orderID, int goodID) {
        this.id = id;
        this.orderID = orderID;
        this.goodID = goodID;
    }

    public int getID() {
        return id;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getGoodID() {
        return goodID;
    } 
}
