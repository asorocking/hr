package com.asorokin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Homework11 {

    public static void main(String[] args) throws FileNotFoundException {
        String enterString, realPath = "";
        int command = 0;
        //check fileSystem.txt for avaiable
        try {
            File file = new File("fileSystem.txt");
            if (file.exists()) {
                Parser.mPath = FileToPath.fileToPath();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Saved file system not found");
        }
        
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите путь, команду print или close:");
            enterString = sc.nextLine();

            //Choose command    
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
                    System.out.println("Зашли в case 1");
                    break;
                case 2:
                    Parser.parsePath(realPath);
                    System.out.println("Зашли в case 2");
                    break;
                case 3:
                    PathToFile.pathToFile(Parser.newPath);
                    System.out.println("Зашли в case 3");
                    break;
            }
        } while (!enterString.equals("close"));

    }
}

class Printer {

    //prints folder tree
    public static void print(List<Component> mPath) throws FileNotFoundException {
        //check fileSystem.txt for avaiable
        File file = new File("fileSystem.txt");
        if (mPath.isEmpty() && file.exists()) {
            mPath = FileToPath.fileToPath();
        }

        for (int i = 0; i < mPath.size(); i++) {
            System.out.println(mPath.get(i).getName() + "/");
            System.out.print("  ");
        }
    }
}

class Parser {

    public static List<Component> mPath = new ArrayList<Component>();
    public static List<Component> newPath = new ArrayList<Component>();
    static String[] subStr;
    static String delimeter = "/";

    public static void parsePath(String realPath) throws FileNotFoundException {
        //split path string by /
        subStr = realPath.split(delimeter);
        //check existence and save first component of path
        if (isLegalSymbol(subStr[0])
                && !isExistElement(subStr[0], "FileSystem", 0)) {
            //save to arrayList first component with name, 
            //parent's name and nesting level
            newPath.add(new Component(subStr[0], "FileSystem", 0));
        }
        //check exist and save other component of path
        for (int i = 1; i < subStr.length; i++) {
            //for folders
            if (subStr[i].indexOf('.') == -1) {
                //check for legal symbols and exist
                if (isLegalSymbol(subStr[i])
                        && !isExistElement(subStr[i], subStr[i - 1], i)) {
                    newPath.add(new Component(subStr[i], subStr[i - 1], i));
                }
                //for files
            } else {
                if (isLegalSymbol(subStr[i])
                        && !isExistElement(subStr[i], subStr[i - 1], i)) {
                    newPath.add(new Component(subStr[i], subStr[i - 1], i));
                }
                //exit from loop after first finding of file
                break;
            }
        }
    }

    //checking for exist
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

    //checking for legal symbols
    private static boolean isLegalSymbol(String str) {
        return str.matches("^[a-zA-Z0-9-_.\\s]+$");
    }
}

class Component {

    String name = "";
    String parent = "";
    int level = 0;

    public Component() {

    }

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
