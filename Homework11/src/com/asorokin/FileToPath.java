/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asorokin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author sorokin
 */
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
