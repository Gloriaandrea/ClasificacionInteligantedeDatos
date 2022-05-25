package jade.src.gd;

public class GD {
    public static double alfa = 0.001;
    public static double b0 = 0;
    public static double bactual;
    public static double bnueva;
    public static double error1;
    public static double error2;
    public static double xPrueba=30;
    
    public static void execute(){
        bactual=helper.definirB1();
        helper.displayarEcuaciones();
        
        do{
        calcularBNueva();
        calcularError();
        if(error1>error2)
            bactual=bnueva;
            
        }while(error1>error2);
        
        resultado();
        prediccion();
    }

    public static void calcularBNueva(){
        bnueva=helper.calcularBNueva(bactual, alfa,b0);
    }

    public static void calcularError(){
        error1=helper.calcularError(bactual,b0);
        //System.out.println("error1="+ Double.toString(error1));
        error2=helper.calcularError(bnueva,b0);
        //System.out.println("error2="+ Double.toString(error2));
    }

    public static void resultado(){
        System.out.println("b1="+ Double.toString(bactual));

        System.out.println("E = 1/n * sumatoria (yi -(b0+b1xi))^2");
        System.out.println("error="+ Double.toString(error1));

    }
    public static void prediccion(){
        System.out.println("Prediccion");

        System.out.println("y = b0 + b1 * x1");
        System.out.println("y = "+ Double.toString(b0) + "+" +Double.toString(bactual)+ " * " + Double.toString(xPrueba));
        System.out.println("y="+Double.toString( b0+bactual*xPrueba));

    }

    
}
