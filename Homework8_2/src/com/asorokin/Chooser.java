package com.asorokin;

import java.util.ArrayList;
import java.util.List;

public class Chooser {

    private String companyName;
    private int price;
    private boolean require;

    List<Chooser> chooserList = new ArrayList<Chooser>();
    List<Chooser> requireList = new ArrayList<Chooser>();

    public Chooser() {

    }

    public Chooser(boolean require, String companyName, int price) {
        this.require = require;
        this.companyName = companyName;
        this.price = price;
    }

    public boolean getRequire() {
        return require;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getPrice() {
        return price;
    }

    public String choose() {
        for (Chooser cl : chooserList) {
            if (cl.getRequire() != false) {
                requireList.add(cl);
            }
        }
        
        if (requireList.isEmpty()) {
            return "Tender is fail";
        } else {
            for (int i = requireList.size() - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (requireList.get(j).getPrice() > requireList.get(j + 1).getPrice()) {
                        Chooser temp = requireList.get(j);
                        requireList.set(j, requireList.get(j + 1));
                        requireList.set(j + 1, temp);
                    }
                }
            }
        }
        return requireList.get(0).getCompanyName();
    }
}
