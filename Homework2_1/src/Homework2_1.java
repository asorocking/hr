public class Homework2_1{
    public static void main(String[] args) {
        //declarate variables
        int a, p; 
        double m1, m2, G;
        
        //initialize variables over args from command line
        a = Integer.parseInt(args[0]);
        p = Integer.parseInt(args[1]);
        m1 = Double.parseDouble(args[2]);
        m2 = Double.parseDouble(args[3]);
        
        //invoke "calculate" method with parameters
        G = calculate(a, p, m1, m2);
        
        //display result
        System.out.println(G);        
    }
    
    //"calculate" method
    public static double calculate(int a, int p, double m1, double m2){
        //declarate and initialize "pi" variable over "Math.PI" const  
        double pi = java.lang.Math.PI;
        //calculate G using "Math.pow" method
        double G = 4 * Math.pow(pi, 2) * Math.pow(a, 3) / 
            (Math.pow(p, 2) * (m1 + m2));
        return(G);
    }
    
}
