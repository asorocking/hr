package com.asorokin;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PathToFile {

    public static List<Component> mPath = new ArrayList<Component>();

    public PathToFile(List<Component> mPath) {
        this.mPath = mPath;
    }

    public static void pathToFile(List<Component> mPath) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("fileSystem.txt"));
            Component component = new Component();

            for (int i = 0; i < mPath.size(); i++) {

                component = mPath.get(i);

                String line = "";
                line = component.getName() + "/" + component.getParent() + "/" + component.getLevel();

                bw.write(line + "\n");
                bw.flush();

            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            System.out.println("IOException" + e);
        }
    }

}
