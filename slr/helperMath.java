package jade.src.slr;

import java.lang.Math;


public class helperMath{
    private static double y[]=dataset.get_Y();
    private static double x[]=dataset.get_X();
    
    public static double sumaX(){
        double suma=0;
        for (int i = 0; i < x.length; i++) {
            suma += x[i];
        }
        return suma;
    }
    public static double sumaY(){
        double suma=0;
        for (int i = 0; i < y.length; i++) {
            suma += y[i];
        }
        return suma;
    }
    public static double sumaXY(){
        double suma=0;
        for (int i = 0; i < x.length; i++) {
            suma += x[i]*y[i];
        }
        return suma;
    }
    public static double sumaX2(){
        double suma=0;
        for (int i = 0; i < x.length; i++) {
            suma +=Math.pow(x[i],2);
        }
        return suma;
    }
    public static int getN(){
        return x.length;
    }


    

}