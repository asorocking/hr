package com.asorokin;

import java.util.ArrayList;
import java.util.List;

public class Good {

    private int goodID;
    private String goodTitle;
    private float goodPrice;
    public static List<Good> goods = new ArrayList<Good>();

    public Good() {

    }

    public Good(String goodTitle, float goodPrice) {
        this.goodTitle = goodTitle;
        this.goodPrice = goodPrice;
    }

    public int getGoodID() {
        return goodID;
    }

    public String getGoodTitle() {
        return goodTitle;
    }

    public float getGoodPrice() {
        return goodPrice;
    }

    protected static void createListOfGoods() {
        goods.add(new Good("Mobile phone", (float) 10.0));
        goods.add(new Good("Book", (float) 5.5));
        goods.add(new Good("Pencil", (float) 0.3));
        goods.add(new Good("Pen", (float) 1.2));
    }

    public static List<Good> getListOfGoods() {
        return goods;
    }
}
