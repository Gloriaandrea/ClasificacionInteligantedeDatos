package jade.src.lr;

public class LR {
    private static double y[]=dataset.get_Y();
    private static double x[][]=dataset.get_X();
    public static double alfa = 0.1;
    public static double bactual[];
    public static double bnueva[];
    public static double error1;
    public static double error2;
    public static double xPrueba[]={3.5,4};
    public static int cont=0;
    public static boolean bandera=false;
    public static void execute(){
    betasCeros();
    helper.displayarEcuaciones();
    
    while(!bandera){
        calcularBNueva();
        probar();
        bactual=bnueva;
    }
    
    }

    public static void betasCeros(){
        bactual=helper.betasCeros();
    }
    public static void calcularBNueva(){
        
        bnueva=helper.calcularBNueva(bactual, alfa);
    }
    public static void probar(){
       bandera= helper.probar(bactual);
       if(bandera){
           predecir();
       }
       bandera= helper.probar(bnueva); 
       if(bandera){
            bactual=bnueva;
            predecir();
        }  
    }
    public static void predecir(){
        helper.prediccion(bactual, xPrueba);  
 
     }
    
    
}
