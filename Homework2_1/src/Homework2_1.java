public class Homework2_1{
    public static void main(String[] args) {
        int a, p;
        double m1, m2, G;
        
        a = Integer.parseInt(args[0]);
        p = Integer.parseInt(args[1]);
        m1 = Double.parseDouble(args[2]);
        m2 = Double.parseDouble(args[3]);
        
        G = calculate(a, p, m1, m2);
        
        System.out.println(G);        
    }
    
    public static double calculate(int a, int p, double m1, double m2){
        double pi = java.lang.Math.PI;
        double G = 4 * Math.pow(pi, 2) * Math.pow(a, 3) / 
            (Math.pow(p, 2) * (m1 + m2));
        return(G);
    }
    
}
