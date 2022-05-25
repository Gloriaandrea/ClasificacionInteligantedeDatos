package jade.src.slr;

import jade.src.slr.helperMath;

public class SLR{
    public static double b0;
    public static double b1;
    public static double x=11;
    public static void execute(){
        
        calcularB1();
        calcularB0();
        displayarEcuacion();
        pronosticar();
    }
    

    public static void calcularB0(){
        //(b0=sumaY-b1*sumax)/n

        b0=(helperMath.sumaY()-b1*helperMath.sumaX())/helperMath.getN();
        System.out.println("b0 = "+b0);
      
        
    }
    public static void calcularB1(){
        //b1=(nsumaXY-(sumaX)(sumaY))/(nsumaX2-sumax*sumax)
        b1=(helperMath.getN()*helperMath.sumaXY()-helperMath.sumaX()*helperMath.sumaY())/(helperMath.getN()*helperMath.sumaX2()-helperMath.sumaX()*helperMath.sumaX());
        System.out.println("b1 = "+b1);
    }
    public static void displayarEcuacion(){
        System.out.println(" y = B0 + B1x1");
        System.out.println(" y ="+ Double.toString(b0)+"+" + Double.toString(b1)+"*"+Double.toString(x));
    }
    public static void pronosticar(){
        
        double y= b0+b1*x;
        System.out.println("Para el valor de x = "+x+" y es igual a :"+ y);

    }

}