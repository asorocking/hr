/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asorokin;

import java.util.Iterator;
import javax.xml.bind.Validator;

/**
 *
 * @author sorokin
 */
public class Vent {
    public Folder add(String name) {
        //Если это ФАЙЛ		
        if (Validator.isFile(name)) {
            	            //Перебираем итератором коллекцию fileTree	
	            for (Iterator<Composite> iterator = fileTree.iterator(); iterator.hasNext();) {
                	//По очереди присваиваем переменной composite элементы коллекции fileTree
		Composite composite = iterator.next();                
		
		//Если такой ФАЙЛ УЖЕ ЕСТЬ, т.е. если поле name очередного элемента коллекции fileTree совпадает с именем переданным в данный метод, то выходим из 		  метода
	                if (composite.getName().equals(name)) {
	                    return null;
	                }
	            }
	            //Если имя переданное в метод уникально, то в конец коллекции fileTree добавляем файл с именем, переданным в метод и выходим из метода
	            fileTree.addLast(new File(name));
	            return null;
        }

        //Если это ПАПКА
        for (Iterator<Composite> iterator = fileTree.iterator(); iterator.hasNext();) {
            Composite composite = iterator.next();
            //Если такая ПАПКУ УЖЕ ЕСТЬ	
            if (composite.getName().equals(name)) {
                return (Folder) composite;
            }
        }
        //Если же это ПАПКА С УНИКАЛЬНЫМ именем, то
        fileTree.addFirst(new Folder(name));
        return (Folder) fileTree.getFirst();
    }
}