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

            switch (command) {
                case 1:
                    Printer.print(realPath);
                    break;
                case 2:
                    Parser.parsePath(realPath);
                    break;
            }
        } while (!enterString.equals("close"));

    }
}

//Client
class Printer {

    static String[] subStr;
    static String delimeter = "/";

    public static void print(String realPath) {
        subStr = realPath.split(delimeter);
        // Вывод результата на экран
        for (int i = 0; i < subStr.length; i++) {
            System.out.println(subStr[i]);
        }
    }
}

class Parser {

    public static List<Component> mPath = new ArrayList<Component>();
    static String[] subStr;
    static String delimeter = "/";

    public static void parsePath(String realPath) {
        subStr = realPath.split(delimeter);
        if (isLegalSymbol(subStr[0]) && !isExistElement(subStr[0], "FileSystem")) {
            mPath.add(new Directory(subStr[0], "FileSystem", 0));
        }        
        for (int i = 1; i < subStr.length; i++) {
            if (subStr[i].indexOf('.') == -1) {
                if (isLegalSymbol(subStr[i]) && !isExistElement(subStr[i], subStr[i-1])) {
                    mPath.add(new Directory(subStr[i], subStr[i-1], i));
                }
            } else {
                if (isLegalSymbol(subStr[i]) && !isExistElement(subStr[i], subStr[i-1])) {
                    mPath.add(new File(subStr[i], subStr[i-1], i));
                }
                break;
            }
        }

        print(mPath);
    }
    
    private static void print(List<Component> mPath) {
        
        for (int i = 0; i < mPath.size(); i++) 
            {
            System.out.println("Вывод из mPath " + mPath.get(i).getLevel() + ": " + mPath.get(i).getParent() + "/" + mPath.get(i).getName());
        }
    }
    
    private static boolean isExistElement(String name, String parent) {
        boolean result = false;
        
        for (int i = 0; i < mPath.size(); i++) {
            boolean parentExist = mPath.get(i).getParent().equals(parent);
            boolean nameExist = mPath.get(i).getName().equals(name);
            if (parentExist && nameExist) result = true;
        }
        return result;
    }
    
    private static boolean isLegalSymbol(String str) {
        return str.matches("^[a-zA-Z0-9-_.\\s]+$");
    }
}

interface Component {

    

    public String getName();
    
    public String getParent();
    
    public int getLevel();

    public void add(Component component);

    public void remove(Component component);

    public void print();
}

class Directory implements Component {

    private List<Component> components = new ArrayList<Component>();
    String name = "";
    String parent = "";
    int level = 0;

    public Directory(String name, String parent, int level) {
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
    
    public int getLevel(){
        return level;
    }
    

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public void print() {
        System.out.println("Узел " + name);
        System.out.println("Подузлы:");
        for (int i = 0; i < components.size(); i++) {
            components.get(i).print();
        }
    }
}

class File implements Component {

    String name = "";
    String parent = "";
    int level = 0;

    public File(String name, String parent, int level) {
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
    public int getLevel(){
        return level;
    }
    
    public void add(Component component) {

    }

    public void remove(Component component) {

    }

    public void print() {
        System.out.println("Файл " + name);
    }

}
