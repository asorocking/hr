package com.asorokin;

import java.util.ArrayList;
import java.util.List;

public class Homework8_2 {

    public static void main(String[] args) {
        List<Require> requireList = new ArrayList<Require>();
        requireList.add(new Require(WorkersEnum.ENGINEER, 6));
        requireList.add(new Require(WorkersEnum.BUILDER, 5));
        requireList.add(new Require(WorkersEnum.CONCRETER, 2));
        requireList.add(new Require(WorkersEnum.ELECTRICIAN, 3));
        requireList.add(new Require(WorkersEnum.FINISHER, 2));
        Require.print(requireList);
        

        CompanyOne cOne = new CompanyOne();
        cOne.companyOneWorkerList.add(new Worker("Ivanov", new WorkersEnum[]{WorkersEnum.ENGINEER, WorkersEnum.BUILDER}));
        cOne.companyOneWorkerList.add(new Worker("Petrov", new WorkersEnum[]{WorkersEnum.ENGINEER, WorkersEnum.BUILDER, WorkersEnum.CONCRETER, WorkersEnum.ELECTRICIAN, WorkersEnum.FINISHER}));
        cOne.companyOneWorkerList.add(new Worker("Sidorov", new WorkersEnum[]{WorkersEnum.ENGINEER}));
        cOne.companyOneWorkerList.add(new Worker("Vasilevov", new WorkersEnum[]{WorkersEnum.ENGINEER}));
        cOne.companyOneWorkerList.add(new Worker("Grishinov", new WorkersEnum[]{WorkersEnum.ENGINEER}));
        cOne.companyOneWorkerList.add(new Worker("Pashinov", new WorkersEnum[]{WorkersEnum.BUILDER}));
        cOne.companyOneWorkerList.add(new Worker("Jashinov", new WorkersEnum[]{WorkersEnum.BUILDER}));
        cOne.companyOneWorkerList.add(new Worker("Kostinov", new WorkersEnum[]{WorkersEnum.BUILDER, WorkersEnum.CONCRETER}));
        cOne.companyOneWorkerList.add(new Worker("Leshinov", new WorkersEnum[]{WorkersEnum.ENGINEER, WorkersEnum.ELECTRICIAN}));
        cOne.companyOneWorkerList.add(new Worker("Vadimov", new WorkersEnum[]{WorkersEnum.ELECTRICIAN}));
        cOne.companyOneWorkerList.add(new Worker("Andreevov", new WorkersEnum[]{WorkersEnum.FINISHER}));

        Worker w = new Worker();
        w.print(cOne.companyOneWorkerList);
        
        
        Calculator calc = new Calculator();
        Chooser ch = new Chooser();
        
        List<
        
        ch.choose(requireList, calc.calculate(cOne.companyOneWorkerList));
        
    }

}

class Require {

    WorkersEnum workerTitle;
    int requireWorkerQuantity;

    public Require(WorkersEnum workerTitle, int requireWorkerQuantity) {
        this.workerTitle = workerTitle;
        this.requireWorkerQuantity = requireWorkerQuantity;
    }

    public WorkersEnum getWorkerTitle() {
        return workerTitle;
    }

    public int getRequireWorkerQuantity() {
        return requireWorkerQuantity;
    }

    public static void print(List<Require> requireList) {
        System.out.println("We are Future Libriary. Our requirments:");
        for (Require rl : requireList) {
            System.out.println(rl.getWorkerTitle() + ": " + rl.getRequireWorkerQuantity());
        }
    }
}

enum WorkersEnum {
    ENGINEER,
    BUILDER,
    CONCRETER,
    ELECTRICIAN,
    FINISHER
}
