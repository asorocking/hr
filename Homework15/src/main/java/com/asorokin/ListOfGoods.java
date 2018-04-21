package com.asorokin;

import java.util.ArrayList;
import java.util.List;

public class ListOfGoods {

    public static List<Good> getListOfGoods() {
        List<Good> goods = new ArrayList<Good>();
        goods.add(new Good("Mobile phone", 10.0));
        goods.add(new Good("Book", 5.5));
        goods.add(new Good("Pencil", 0.3));
        goods.add(new Good("Pen", 1.2));
        
        return goods;
    }
}
