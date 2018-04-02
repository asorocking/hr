package com.asorokin;

interface Strategy {

    int[] sorting(int[] array);
}

//implements Strategy methods
class ConcreteStrategySelectionSort implements Strategy {

    // Do selectioin sorting
    public int[] sorting(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int min_i = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                int tmp = array[i];
                array[i] = array[min_i];
                array[min_i] = tmp;
            }
        }
        return array;
    }
}

class ConcreteStrategyBubbleSort implements Strategy {

    // Doing bubble sort
    public int[] sorting(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}

//context class
class Context {

    private Strategy strategy;

    // Constructor
    public Context() {
    }

    // Set new strategy
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int[] executeStrategy(int[] array) {
        return strategy.sorting(array);
    }
}

//Test app
class Homework4_2 {

    public static void main(String[] args) {
        Context context = new Context();

        //initialize and print source array
        int[] array = {2, 4, 1, 5, 0, 3, 3, 7, 6};
        System.out.print("Исходный массив: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        //use selection sort
        context.setStrategy(new ConcreteStrategySelectionSort());
        int[] resultA = context.executeStrategy(array);

        //use buble sort
        context.setStrategy(new ConcreteStrategyBubbleSort());
        int[] resultB = context.executeStrategy(array);

        //print selection sort array
        System.out.print("  Сорт. выбором: ");
        for (int i = 0; i < resultA.length; i++) {
            System.out.print(resultA[i] + " ");
        }
        System.out.println();

        //print buble sort array
        System.out.print("    Пузырьковая: ");
        for (int i = 0; i < resultB.length; i++) {
            System.out.print(resultB[i] + " ");
        }
        System.out.println();
    }
}
