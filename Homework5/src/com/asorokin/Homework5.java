package com.asorokin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Homework5 {

    public static void main(String[] args) {
        String enterString, realPath = "";
        int command = 3;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите путь или команды print или close:");
            enterString = sc.nextLine();

            if (enterString.equals("print")) {
                command = 1;
            }
            if (enterString.indexOf("/") != -1) {
                realPath = enterString;
                command = 2;
            }
            if (enterString.equals("close")) {
                command = 3;
            }

            switch (command) {
                case 1:
                    Printer.print(Parser.mPath);
                    break;
                case 2:
                    Parser.parsePath(realPath);
                    break;
            }
        } while (!enterString.equals("close"));

    }
}

class Printer {

    public static void print(List<Component> mPath) {
        for (int i = 0; i < mPath.size(); i++) {
            System.out.println(mPath.get(i).getName() + "/");
            System.out.print("  ");
        }
    }
}

class Parser {

    public static List<Component> mPath = new ArrayList<Component>();
    static String[] subStr;
    static String delimeter = "/";

    public static void parsePath(String realPath) {
        subStr = realPath.split(delimeter);
        if (isLegalSymbol(subStr[0]) && !isExistElement(subStr[0], "FileSystem", 0)) {
            mPath.add(new Component(subStr[0], "FileSystem", 0));
        }
        for (int i = 1; i < subStr.length; i++) {
            if (subStr[i].indexOf('.') == -1) {
                if (isLegalSymbol(subStr[i]) && !isExistElement(subStr[i], subStr[i - 1], i)) {
                    mPath.add(new Component(subStr[i], subStr[i - 1], i));
                }
            } else {
                if (isLegalSymbol(subStr[i]) && !isExistElement(subStr[i], subStr[i - 1], i)) {
                    mPath.add(new Component(subStr[i], subStr[i - 1], i));
                }
                break;
            }
        }
    }

    private static boolean isExistElement(String name, String parent, int i) {
        boolean result = false;
        for (int j = 0; j < mPath.size(); j++) {
            boolean parentExist = mPath.get(j).getParent().equals(parent);
            boolean nameExist = mPath.get(j).getName().equals(name);
            boolean levelEquals = mPath.get(j).getLevel() == i;
            if (parentExist && nameExist && levelEquals) {
                result = true;
            }
        }
        return result;
    }

    private static boolean isLegalSymbol(String str) {
        return str.matches("^[a-zA-Z0-9-_.\\s]+$");
    }
}

class Component {

    String name = "";
    String parent = "";
    int level = 0;

    public Component(String name, String parent, int level) {
        this.name = name;
        this.parent = parent;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getParent() {
        return parent;
    }

    public int getLevel() {
        return level;
    }
}


