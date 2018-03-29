
package com.asorokin;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PathToFile {
    public static List<Component> newPath = new ArrayList<Component>();
    
    public PathToFile(List<Component> mPath){
        this.newPath = mPath;
    } 
    
    public static void pathToFile (List<Component> mPath){
        
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("fileSystem.txt", true));
            Component component = new Component();                        
            
            for (int i = 0; i < newPath.size(); i++){
                
                component = newPath.get(i);
                
                String line = "";
                line = component.getName() + "/" + component.getParent() + "/" + component.getLevel();
                              
                bw.write(line + "\n");
                bw.flush();
                            
            }
            
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");            
        } catch (IOException e){
            System.out.println("IOException" + e);            
        }  
    } 
            
}