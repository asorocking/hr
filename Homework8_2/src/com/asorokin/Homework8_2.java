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
        
        CompanyTwo cTwo = new CompanyTwo();
        cTwo.companyTwoWorkerList.add(new Worker("McDonald", new WorkersEnum[]{WorkersEnum.ENGINEER, WorkersEnum.BUILDER}));
        cTwo.companyTwoWorkerList.add(new Worker("McRonald", new WorkersEnum[]{WorkersEnum.ENGINEER, WorkersEnum.BUILDER, WorkersEnum.CONCRETER, WorkersEnum.ELECTRICIAN, WorkersEnum.FINISHER}));
        cTwo.companyTwoWorkerList.add(new Worker("McRoland", new WorkersEnum[]{WorkersEnum.BUILDER}));
        cTwo.companyTwoWorkerList.add(new Worker("McGregore", new WorkersEnum[]{WorkersEnum.BUILDER, WorkersEnum.ELECTRICIAN}));
        cTwo.companyTwoWorkerList.add(new Worker("McWilliam", new WorkersEnum[]{WorkersEnum.ENGINEER, WorkersEnum.ELECTRICIAN}));
        cTwo.companyTwoWorkerList.add(new Worker("McAlbert", new WorkersEnum[]{WorkersEnum.BUILDER, WorkersEnum.CONCRETER}));
        cTwo.companyTwoWorkerList.add(new Worker("McLincoln", new WorkersEnum[]{WorkersEnum.BUILDER, WorkersEnum.CONCRETER}));
        cTwo.companyTwoWorkerList.add(new Worker("McReigan", new WorkersEnum[]{WorkersEnum.BUILDER, WorkersEnum.CONCRETER}));
        cTwo.companyTwoWorkerList.add(new Worker("McClinton", new WorkersEnum[]{WorkersEnum.ENGINEER, WorkersEnum.ELECTRICIAN}));
        cTwo.companyTwoWorkerList.add(new Worker("McQuentin", new WorkersEnum[]{WorkersEnum.ELECTRICIAN}));
        cTwo.companyTwoWorkerList.add(new Worker("McBurger", new WorkersEnum[]{WorkersEnum.FINISHER, WorkersEnum.ELECTRICIAN}));
        
        CompanyThree cThree = new CompanyThree();
        cThree.companyThreeWorkerList.add(new Worker("Lee", new WorkersEnum[]{WorkersEnum.CONCRETER, WorkersEnum.BUILDER}));
        cThree.companyThreeWorkerList.add(new Worker("Mee", new WorkersEnum[]{WorkersEnum.CONCRETER, WorkersEnum.BUILDER, WorkersEnum.CONCRETER, WorkersEnum.ELECTRICIAN, WorkersEnum.FINISHER}));
        cThree.companyThreeWorkerList.add(new Worker("Nee", new WorkersEnum[]{WorkersEnum.ENGINEER, WorkersEnum.ELECTRICIAN}));
        cThree.companyThreeWorkerList.add(new Worker("Bee", new WorkersEnum[]{WorkersEnum.CONCRETER}));
        cThree.companyThreeWorkerList.add(new Worker("Gee", new WorkersEnum[]{WorkersEnum.ENGINEER}));
        cThree.companyThreeWorkerList.add(new Worker("Tee", new WorkersEnum[]{WorkersEnum.BUILDER}));
        cThree.companyThreeWorkerList.add(new Worker("Wee", new WorkersEnum[]{WorkersEnum.CONCRETER}));
        cThree.companyThreeWorkerList.add(new Worker("Vee", new WorkersEnum[]{WorkersEnum.BUILDER, WorkersEnum.CONCRETER}));
        cThree.companyThreeWorkerList.add(new Worker("Zee", new WorkersEnum[]{WorkersEnum.ENGINEER, WorkersEnum.ELECTRICIAN}));
        cThree.companyThreeWorkerList.add(new Worker("See", new WorkersEnum[]{WorkersEnum.CONCRETER}));
        cThree.companyThreeWorkerList.add(new Worker("Kee", new WorkersEnum[]{WorkersEnum.FINISHER}));
        
        CompanyFour cFour = new CompanyFour();
        cFour.companyFourWorkerList.add(new Worker("O'Reily", new WorkersEnum[]{WorkersEnum.ENGINEER, WorkersEnum.BUILDER}));
        cFour.companyFourWorkerList.add(new Worker("O'Raily", new WorkersEnum[]{WorkersEnum.ENGINEER, WorkersEnum.BUILDER, WorkersEnum.CONCRETER, WorkersEnum.ELECTRICIAN, WorkersEnum.FINISHER}));
        cFour.companyFourWorkerList.add(new Worker("O'Regby", new WorkersEnum[]{WorkersEnum.ENGINEER, WorkersEnum.BUILDER, WorkersEnum.CONCRETER, WorkersEnum.ELECTRICIAN, WorkersEnum.FINISHER}));
        cFour.companyFourWorkerList.add(new Worker("O'Rusevelt", new WorkersEnum[]{WorkersEnum.FINISHER}));
        cFour.companyFourWorkerList.add(new Worker("O'Richard", new WorkersEnum[]{WorkersEnum.FINISHER}));
        cFour.companyFourWorkerList.add(new Worker("O'Ramsey", new WorkersEnum[]{WorkersEnum.FINISHER}));
        cFour.companyFourWorkerList.add(new Worker("O'Realy", new WorkersEnum[]{WorkersEnum.ENGINEER, WorkersEnum.BUILDER, WorkersEnum.CONCRETER, WorkersEnum.ELECTRICIAN, WorkersEnum.FINISHER}));
        cFour.companyFourWorkerList.add(new Worker("O'Ready", new WorkersEnum[]{WorkersEnum.BUILDER, WorkersEnum.CONCRETER}));
        cFour.companyFourWorkerList.add(new Worker("O'Rally", new WorkersEnum[]{WorkersEnum.ENGINEER, WorkersEnum.ELECTRICIAN}));
        cFour.companyFourWorkerList.add(new Worker("O'Reebok", new WorkersEnum[]{WorkersEnum.ELECTRICIAN}));
        cFour.companyFourWorkerList.add(new Worker("O'Rio", new WorkersEnum[]{WorkersEnum.ENGINEER, WorkersEnum.FINISHER}));
        System.out.println();
        
        Worker w = new Worker();

        System.out.println(cOne.getCompanyName() + " with price " + cOne.getPrice());
        w.print(cOne.companyOneWorkerList);
        System.out.println();

        System.out.println(cTwo.getCompanyName() + " with price " + cTwo.getPrice());
        w.print(cTwo.companyTwoWorkerList);
        System.out.println();

        System.out.println(cThree.getCompanyName() + " with price " + cThree.getPrice());
        w.print(cThree.companyThreeWorkerList);
        System.out.println();

        System.out.println(cFour.getCompanyName() + " with price " + cFour.getPrice());
        w.print(cFour.companyFourWorkerList);
        System.out.println();
        
        Calculator calc = new Calculator();
        Comparer comparer = new Comparer();
        Chooser chooser = new Chooser();
        
        chooser.chooserList.add(new Chooser(comparer.comparing(requireList, calc.calculate(cOne.companyOneWorkerList)), cOne.getCompanyName(), cOne.getPrice()));
        chooser.chooserList.add(new Chooser(comparer.comparing(requireList, calc.calculate(cTwo.companyTwoWorkerList)), cTwo.getCompanyName(), cTwo.getPrice()));
        chooser.chooserList.add(new Chooser(comparer.comparing(requireList, calc.calculate(cThree.companyThreeWorkerList)), cThree.getCompanyName(), cThree.getPrice()));
        chooser.chooserList.add(new Chooser(comparer.comparing(requireList, calc.calculate(cFour.companyFourWorkerList)), cFour.getCompanyName(), cFour.getPrice()));
                
        System.out.println(chooser.choose());
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
