package jade.src.lr;

public class helper {
    private static double y[]=dataset.get_Y();
    private static double x[][]=dataset.get_X();

    public static double[] betasCeros (){      
        double auxiliar[]=new double[10];
       for(int i =0;i<x[0].length;i++){
        auxiliar[i]=0;
       }
        return auxiliar;
    }

    public static double sigmoide(double b[]){
        
        double resultado;
        int j;
        double rr=0;
        for(int i=0;i<x.length;i++){

            resultado=0;
            resultado+=b[0];
            for(j=1;j<x[0].length;j++ ){
                resultado+=b[j]*x[i][j];
            }
            double rfinal=Math.pow(Math.E, -resultado);
            rfinal+=1;
            rfinal=1/rfinal;
            rr+=rfinal;
        }
        rr/=x.length;
        
            
            return rr;
    }

    public static double []calcularBNueva(double b[], double alfa){
        double sigFunction=sigmoide(b);
        double rArray[]=new double[10];
        for(int n=0;n<x[0].length;n++){
        double resultado=0;
        double resultadob=0;
        
        for(int i =0;i<x.length;i++){
            resultado=0;
            
            resultado+=y[i]-sigFunction;
            resultado*=x[n][i];
            resultadob+=resultado;
        }
            resultadob*=alfa;
            resultadob+=b[n];

            rArray[n]   = resultadob;
        }
        return(rArray); 
    }
    
    public static void displayarEcuaciones(){
        System.out.println("wj = wj + a * sumatoria ((yi - sigmoide) xi)");
        System.out.println("y = 1/(1 + e^-(b0 + xi*bi))");
    }

    
    public static void prediccion(double bactual[], double xPrueba[]){
        System.out.println("Prediccion");

        System.out.println("y = 1/(1 + e^-(b0 + xi*bi))");
        double yresult=bactual[0];
        System.out.print("y = 1/(1 + e^-("+ Double.toString(bactual[0]));
        for(int i =1;i<x[0].length;i++){
        System.out.print("+" +Double.toString(bactual[i])+ " * " + Double.toString(xPrueba[i-1]));
        yresult+=bactual[i]*xPrueba[i-1];
        }
        double yfinal=Math.pow(Math.E, -yresult);
        yfinal+=1;
        yfinal=1/yfinal;
        System.out.println("))");
        if(yfinal==.5)yfinal=.49;
        long resultadoint=Math.round(yfinal);

        System.out.println("y = "+Double.toString(resultadoint));
    }
    public static  boolean probar(double b[]){
        double resultado;
        int j;
        for(int i=0;i<x.length;i++){
            resultado=0;
            resultado+=b[0];
            for(j=1;j<x[0].length;j++ ){
                resultado+=b[j]*x[i][j];
            }
            double rfinal=Math.pow(Math.E, -resultado);
            rfinal+=1;
            rfinal=1/rfinal;
            if(rfinal==.5)rfinal=.49;
            long resultadoint=Math.round(rfinal);
            if(resultadoint!=y[i]){
            return false;
            }
        }
        return true;
    }
}