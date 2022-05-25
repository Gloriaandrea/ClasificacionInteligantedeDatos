package jade.src.knn;
public class helper {
    private static String y[]=dataset.get_Y();
    private static double x[][]=dataset.get_X();
    
    private static int instancesNum=y.length;
    public static double desvStd[];
    public static double m[];
    

    public static double [][] normalizar(double x[][]){
        m=media();
        double auxiliar [][]=x;
        desvStd=desviacion(m);
        for(int i =0;i<x[0].length;i++){
            
               for(int j=0;j<x.length;j++){
                    auxiliar[j][i]=(x[j][i]-m[i])/desvStd[i];
               } 
           } 
           return auxiliar;
    }
    public static double[] normalizarInst(double x[]){
         double auxiliar[]=new double[x.length];   
               for(int j=0;j<x.length;j++){
                    auxiliar[j]=(x[j]-m[j])/desvStd[j];
               } 
        return auxiliar;
    }

    public static double[] media (){      
        double auxiliar[]=new double [instancesNum];
        double suma;
       for(int i =0;i<x[0].length;i++){
        suma=0;
           for(int j=0;j<x.length;j++){
                suma+=x[j][i];
           }
           
        auxiliar[i]=suma/instancesNum;
       }
        return auxiliar;
    }

    public static double[] desviacion (double media[]){      
        double auxiliar[]=new double [instancesNum];
        double suma;
       for(int i =0;i<x[0].length;i++){
        suma=0;
           for(int j=0;j<x.length;j++){
                suma+=(Math.pow((x[j][i]-media[i]),2));
           }
           
        auxiliar[i]=Math.sqrt(suma/(instancesNum-1));
       }
        return auxiliar;
    }
   
    
    public static void displayarEcuaciones(){
        System.out.println("Normalizar = (x-media)/desviacion estandar");
        System.out.println("d = raiz cuadrada((x2-x1)^2+(y2-y1)^2)");
    }

    
   
    
}