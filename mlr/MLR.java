package jade.src.mlr;

public class MLR{
    public static double b[];
    public static double xT[][];
    public static double xTx[][];
    public static double invxTx[][];
    public static double xTy[];
    public static double x[]={9,58};
    public static void execute(){

        obtenerXT();
        obtenerXTx();
        obtenerInversaXTx();
        obtenerXTy();

        obtenerB();

        displayarEcuacion();
        pronosticar();
    }

    public static void obtenerXT(){
        xT=helperMatrix.get_transpuesta(dataset.get_X());
        
    }

    public static void obtenerXTx(){
        xTx=helperMatrix.multiplica_Matriz(xT, dataset.get_X());
        
    }

    
    public static void obtenerInversaXTx(){
       invxTx=helperMatrix.inversa(xTx);
       //helperMatrix.imprime_matriz(xTx, "antes de inversa");
        //invxTx=inversa.matrizInversa(xTx);
        for(int i=0;i<invxTx.length;i++){
            if( Double.isInfinite(invxTx[0][0])){
                System.out.println("La matriz no es inversible ");
               
                System.exit(0);
             
            }

        }
    
        
       
        //helperMatrix.imprime_matriz(invxTx, "inversa");
      
    }

    public static void obtenerXTy(){
        
        xTy=helperMatrix.multiplica_M_V(xT, dataset.get_Y());
        
    }
          
   
        
    public static void obtenerB(){
        
        helperMatrix.imprime_vector(xTy, "xTy");
        b=helperMatrix.multiplica_M_V(invxTx, xTy);
        for(int i=0;i<b.length;i++)
        System.out.println(" B"+ Integer.toString(i) + " = " +b[i]);
        
    }
   
    public static void displayarEcuacion(){
        System.out.println();
        System.out.print("y = B0 ");
        for(int i=1;i<b.length;i++){
            System.out.print("+ B"+Integer.toString(i)+"x"+Integer.toString(i));
        }
        System.out.println();
        System.out.print(" y = "+ Double.toString(b[0]));
        for(int i=1;i<b.length;i++){
        System.out.print( " + "+Double.toString(b[i])+" * "+Double.toString(x[i-1]));
        }
    }
    public static void pronosticar(){
        double y= b[0];
        for(int i=1;i<b.length;i++){
            y+=x[i-1]*b[i];
        }

        System.out.println();
        System.out.print("Para los valores de ");
        for(int i=0;i<x.length;i++){
            System.out.print(" x"+Integer.toString(i+1)+" = "+Double.toString(x[i]));
        }
        System.out.print(" y es igual a : "+Double.toString(y));
        
    }

}