/*import java.util.Scanner;

public class MetodoEuler {
    static double[] hs = {2*Math.pow(10,-1),1*Math.pow(10,-1),5*Math.pow(10,-2)};
    static double h;

    public static double f(double t, double y){
        return 1/(1 + Math.pow(t,2)) - 2*Math.pow(y,2);
    }

    public static double Euler(double t){
        //System.out.println(t);
        if ( t >= 0 && t < h ) return 0;
        //if ( t == 0 ) return 0;
        double k = Euler( t-h);
        return k + h*f(t-h,k);
    }

    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        for (int i = 0; i<3; i++) {
            h = hs[i];
            System.out.println("Para h = " + h + ":");
            double t = 0;
            for (int j=0; t <= 1; j++) {
                System.out.println("y(t_" + j + ") =" + Euler(t));
                //System.out.printf("%s%d%s %f%n","y(",j,") =",Euler(t));
                t += h;
                System.out.println("t = " + t);
            }
            System.out.println("------------------------");
        }
    }
}

 */


public class MetodoEuler{

    public static double f(double t, double y){
        return 1/(1 + Math.pow(t,2)) - 2*Math.pow(y,2);
    }

    public static void main(String[] args) {
        double h = 0.2;
        for (int j=0; j<3; j++) {
            double t = 0.0, y = 0.0, n = 1 / h;
            System.out.println("Para h = " + h + ":");
            for (int i = 0; i <= n; i++){
                System.out.println("y(t_" + i + ") =" + y);
                System.out.println("t: " + t);
                y += h*f(t,y);
                t += h;
            }
            System.out.println("------------------------");
            h /= 2;
        }
    }
}


