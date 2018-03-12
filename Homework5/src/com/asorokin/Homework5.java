package com.asorokin;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * "Component"
 */
interface Path {

    String name = "";
    String extension = "";
    String parent = "";

    //Prints the path.
    public void print();

}

/**
 * "Composite"
 */
class Folder implements Path {
    
    String name = "";
    String extension = "";
    String parent = "";
    
    //Collection of child paths.
    private List<Path> mChildPaths = new ArrayList<Path>();
    
    public Folder (String name, String extension, String parent){
        this.name = name;
        this.extension = extension;
        this.parent = parent;
    }
    
    //Prints the path.
    public void print() {
        for (Path path : mChildPaths) {
            path.print();
        }
    }

    //Adds the path to the composition.
    public void add(Path path) {
        mChildPaths.add(path);
    }

    //Removes the path from the composition.
    public void remove(Path path) {
        mChildPaths.remove(path);
    }

}

/**
 * "Leaf"
 */
class File implements Path {

    String name = "";
    String extension = "";
    String parent = "";

    public File() {
    }

    public File(String name, String extension) {
        this.name = name;
        this.extension = extension;
    }

    //Prints the path.
    public void print() {
        System.out.println(name + "." + extension);
    }

}

/**
 * Client
 */
class Printer {
    static String[] subStr;
    static String delimeter = "/";;
    
    public static void print(String realPath) {
        subStr  = realPath.split(delimeter);
        // Вывод результата на экран
        for (int i = 0; i< subStr.length; i++) {
            System.out.println(subStr[i]);
        }
    }
}

class Parser {
    public static List<File> mFiles = new ArrayList<File>();
    public static void parsePath(String realPath) {
        
    }
    static String[] subStr;
    static String delimeter = "/";;
    
    public static void print(String realPath) {
        int arrayIndex = mFiles.size();
        subStr  = realPath.split(delimeter);
        // Вывод результата на экран
        for (int i = 0; i < subStr.length; i++) {
            mFiles.add(arrayIndex, new File(subStr[subStr.length], subStr[subStr.length-1]));
            System.out.println(subStr[i]);
        }
    }
}

public class Homework5 {

    public static void main(String[] args) {
        /* //Initialize four files
        File file1 = new File("autoexec", "bat");
        File file2 = new File("config", "sys");
        File file3 = new File("client", "mdb");
        File file4 = new File("cbmain", "ex");

        //Initialize three composite paths
        Folder path = new Folder();
        Folder path1 = new Folder();
        Folder path2 = new Folder();

        //Composes the paths
        path1.add(file1);
        path1.add(file2);
        path1.add(file3);

        path2.add(file4);

        path.add(path1);
        path.add(path2);

        //Prints the complete path (four times the string "File").
        path.print();
         */
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

        boolean endOfPath = false;

    }
}
