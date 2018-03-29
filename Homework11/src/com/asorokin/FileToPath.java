package com.asorokin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileToPath {

    public FileToPath() {

    }

    public static List<Component> fileToPath() throws FileNotFoundException {
        List<Component> savedPath = new ArrayList<Component>();
        String[] subStr;
        String tmpStr;

        try {
            BufferedReader br = new BufferedReader(new FileReader("fileSystem.txt"));
            while ((tmpStr = br.readLine()) != null) {
                subStr = tmpStr.split("/");
                savedPath.add(new Component(subStr[0], subStr[1], Integer.valueOf(subStr[2])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            System.out.println("IOException");
        }

        return savedPath;
    }
}
