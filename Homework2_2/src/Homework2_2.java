import java.util.Scanner;

public class Homework2_2 {
    public static void main(String[] args) {
        //create instance of "Scanner" class with "System.in" param
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите параметры:");
        //read data from console, declarate and initialize variables 
        int algorithmId = sc.nextInt();
        int loopType = sc.nextInt();
        int n = sc.nextInt();
        //close scanner 
        sc.close();  
        
        //define algorithm
        switch(algorithmId){
            case 1: 
                chooseFibonacci(n, loopType);
                break;
            case 2: 
                chooseFactorial(n, loopType);
                break;
           default:
                System.out.println("Введите 1 или 2 в качестве первого параметра");
        }
    }
    
    //choose Fibonacci loop depending on the user's choice
    public static void chooseFibonacci(int n, int loopType){
         switch(loopType){
            case 1: 
                calculateFibonacciWhile(n);
                break;
            case 2: 
                calculateFibonacciDoWhile(n);
                break;
            case 3: 
                calculateFibonacciFor(n);
                break;    
            default:
                System.out.println("Введите 1, 2 или 3 в качестве второго параметра");
        } 
    }
    
    //choose factorial loop depending on the user's choice
    public static void chooseFactorial(int n, int loopType){
         switch(loopType){
            case 1: 
                calculateFactorialWhile(n);
                break;
            case 2: 
                calculateFactorialDoWhile(n);
                break;
            case 3: 
                calculateFactorialFor(n);
                break;    
            default:
                System.out.println("Введите 1, 2 или 3 в качестве второго параметра");
        } 
    }
    
    //calculate Fibonacci numbers via While loop
    public static int calculateFibonacciWhile(int n){
        int s = 0;
        int i = 2;
        int n0 = 1;
        int n1 = 1;
        
        //first and second numbers of Fibonacci sequence is 1
        if (n == 1 || n == 2) {
            s = 1;
        //calculate third and more numbers
        } else {
            while (i < n) {
                s = n0 + n1;
                n0 = n1;
                n1 = s;
                i++;
            }
          }
                
        System.out.println("Число Фибоначчи от " + n + " через цикл While равно " + s);
        return(s);
    }
    
    //calculate Fibonacci numbers via Do-While loop
    public static int calculateFibonacciDoWhile(int n){
        int s = 0;
        int i = 3;
        int n0 = 1;
        int n1 = 1;
        
        if (n == 1 || n == 2) {
            s = 1;
        } else {
            do {
                s = n0 + n1;
                n0 = n1;
                n1 = s;
                i++;
            } while (i <= n); 
          }
                
        System.out.println("Число Фибоначчи от " + n + " через цикл DoWhile равно " + s);
        return(s);
    }
    
    //calculate Fibonacci numbers via For loop
    public static int calculateFibonacciFor(int n){
        int s = 0;
        int i;
        int n0 = 1;
        int n1 = 1;
        
        if (n == 1 || n == 2) {
            s = 1;
        } else {
            for (i = 2; i < n; i++){
                s = n0 + n1;
                n0 = n1;
                n1 = s;
            }
          }  
        
        System.out.println("Число Фибоначчи от " + n + " через цикл For равно " + s);
        return(s);
    }
    
    //calculate factorial via While loop
    public static int calculateFactorialWhile(int n){
        int s = 1;
        int i = 0;
        
        while (i < n) {
            s *= i+1;
            i++;
        }  
        
        System.out.println("Факториал числа " + n + " через цикл While равен " + s);
        return(s);
    }
    
    //calculate factorial via Do-While loop
    public static int calculateFactorialDoWhile(int n){
        int s = 1;
        int i = 0;
        
        do {
            s *= i+1;
            i++;
        } while (i < n);
        
        System.out.println("Факториал числа " + n + " через цикл DoWhile равен " + s);
        return(s);
    }
    
    //calculate factorial via For loop
    public static int calculateFactorialFor(int n){
        int s = 1;
        int i;
        
        for (i = 0; i < n; i++){
            s *= i+1;
        }
        
        System.out.println("Факториал числа " + n + " через цикл For равен " + s);
        return(s);
    }
}
