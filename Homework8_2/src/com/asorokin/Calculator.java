package com.asorokin;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    int engineer = 0;
    int builder = 0;
    int concreter = 0;
    int electrician = 0;
    int finisher = 0;
    List<Worker> workerList;

    public Calculator() {
        
    }

    public List<Require> calculate(List<Worker> workerList) {
        List<Require> checkWorkerList = new ArrayList<Require>();
        for (Worker wl : workerList) {
            for (WorkersEnum we : wl.workerTitle) {
                switch (we) {
                    case ENGINEER:
                        engineer++;
                        break;
                    case BUILDER:
                        builder++;
                        break;
                    case CONCRETER:
                        concreter++;
                        break;
                    case ELECTRICIAN:
                        electrician++;
                        break;
                    case FINISHER:
                        finisher++;
                        break;
                }
            }
        }
        checkWorkerList.add(new Require(WorkersEnum.ENGINEER, engineer));
        checkWorkerList.add(new Require(WorkersEnum.BUILDER, builder));
        checkWorkerList.add(new Require(WorkersEnum.CONCRETER, concreter));
        checkWorkerList.add(new Require(WorkersEnum.ELECTRICIAN, electrician));
        checkWorkerList.add(new Require(WorkersEnum.FINISHER, finisher));    
        /*System.out.println("engineer = " + engineer);
        System.out.println("builder = " + builder);
        System.out.println("concreter = " + concreter);
        System.out.println("electrician = " + electrician);
        System.out.println("finisher = " + finisher);*/
        return checkWorkerList;
    }

}
