package com.asorokin;

import java.util.List;

class Worker {
    String workerName;
    WorkersEnum[] workerTitle = new WorkersEnum[5];
    
    public Worker(){
    }
    
    public Worker(String workerName, WorkersEnum[] workerTitleOut){
        this.workerName = workerName;
        this.workerTitle = workerTitleOut;
    }
    
    public String getWorkerName(){
        return workerName;
    }
    
    public WorkersEnum[] getWorkerTitle(){
        return workerTitle;
    }
    
    public void print(List<Worker> workerList) {
        System.out.println("WorkersEnum:");
        for (Worker w : workerList) {
            System.out.print(w.workerName + ": ");
            for (WorkersEnum wt : w.workerTitle) {
                System.out.print(wt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
}