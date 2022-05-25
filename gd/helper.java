package jade.src.gd;
import java.lang.Math;

public class helper {
    private static double y[]=dataset.get_Y();
    private static double x[]=dataset.get_X();
    private static int instanciasNum =y.length;
    public static double definirB1 (){
       
        return y[0];
    }

    public static double calcularBNueva(double bActual, double alfa, double b0){
       /* double sumatoria=0;
            for(int i=0;i<y.length;i++){
                sumatoria+= y[i]-(b0+bActual*x[i]);
                System.out.println("y="+ Double.toString(y[i]));
                System.out.println("x="+ Double.toString(x[i]));
                System.out.println("b="+ Double.toString(bActual));

            }
        return(bActual-alfa*((-2/y.length)*sumatoria));*/
        return(bActual-alfa);
    }
    public static double calcularError(double b1, double b0){
        double sumatoria=0;
            for(int i=0;i<y.length;i++){
                double operacion=y[i]-(b0+(b1*x[i]));
                sumatoria+=Math.pow(operacion, 2) ;
                
            }
            
            Double dIN=Double.valueOf(instanciasNum);
            Double factor=Double.valueOf(1/dIN);
            double error=factor*sumatoria;
            
        return(error);
    }
    public static void displayarEcuaciones(){
        
        System.out.println("E = 1/n * sumatoria (yi -(b0+b1xi))^2");
        //System.out.println("bNueva= bActual - alfa (-2/n * sumatoria (yi - (b0 + b1 xi)))");

    }
}
