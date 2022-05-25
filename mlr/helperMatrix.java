package jade.src.mlr;


public class helperMatrix{
    
    private static double x[][];
    private static double xt[][];
    
    public static double [][] get_transpuesta(double [][] y){
        
        x=y;
        xt=new double [x[0].length][x.length];
        for (int i=0; i < x.length; i++) {
            for (int j=0; j < x[0].length; j++) {
                xt[j][i] = x[i][j];

            }
          }
          //imprime_matriz(xt, "transpuesta");
          
          return xt;
          
    }
//a.length, b[0].length,a[0].length|xTX[i][j] += a[i][k] * b[k][j];
    public static double [][] multiplica_Matriz(double a[][], double b[][]){
        double xTX[][]=new double[a.length][b[0].length] ;
       
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    
                    xTX[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        //imprime_matriz(xTX, "xTx");

        return xTX;

    }

    public static double [] multiplica_M_V(double a[][], double b[]){
        double resultado[]=new double[a.length];
    

        for (int i = 0; i < a.length; i++) {
            
            for (int j = 0; j < a[0].length; j++) {
                resultado[i] += b[j] * a[i][j];
            }
             
        }
       // imprime_vector(resultado, "xtY");
   
        return resultado;

    }
   
    public static double [][] inversa(double matriz [][]){
        double det=1/determinante(matriz);
        double[][] nmatriz=matrizAdjunta(matriz);
        multiplicarMatriz(det,nmatriz);
        return nmatriz;
    }

    public static void multiplicarMatriz(double n, double[][] matriz) {
        for(int i=0;i<matriz.length;i++)
            for(int j=0;j<matriz.length;j++)
                matriz[i][j]*=n;
    }

    public static double[][] matrizAdjunta(double [][] matriz){
        return matrizTranspuesta(matrizCofactores(matriz));
    }

    public static double[][] matrizCofactores(double[][] matriz){
        double[][] nm=new double[matriz.length][matriz.length];
        for(int i=0;i<matriz.length;i++) {
            for(int j=0;j<matriz.length;j++) {
                double[][] det=new double[matriz.length-1][matriz.length-1];
                double detValor;
                for(int k=0;k<matriz.length;k++) {
                    if(k!=i) {
                        for(int l=0;l<matriz.length;l++) {
                            if(l!=j){
                                int indice1=k<i ? k : k-1 ;
                                int indice2=l<j ? l : l-1 ;
                                det[indice1][indice2]=matriz[k][l];
                            }
                        }
                    }
                }
                detValor=determinante(det);
                nm[i][j]=detValor * (double)Math.pow(-1, i+j+2);
            }
        }
        return nm;
    }

    public static double[][] matrizTranspuesta(double [][] matriz){
        double[][]nuevam=new double[matriz[0].length][matriz.length];
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz.length; j++)
                nuevam[i][j]=matriz[j][i];
        }
        return nuevam;
    }

    public static double determinante(double[][] matriz){
        double det;
        if(matriz.length==2){
            det=(matriz[0][0]*matriz[1][1])-(matriz[1][0]*matriz[0][1]);
            return det;
        }
        double suma=0;
        for(int i=0; i<matriz.length; i++){
        double[][] nm=new double[matriz.length-1][matriz.length-1];
            for(int j=0; j<matriz.length; j++){
                if(j!=i){
                    for(int k=1; k<matriz.length; k++){
                        int indice=-1;
                        if(j<i)
                            indice=j;
                        else if(j>i)
                            indice=j-1;
                            nm[indice][k-1]=matriz[j][k];
                    }
                }
            }
            if(i%2==0)
                suma+=matriz[i][0] * determinante(nm);
            else
                suma-=matriz[i][0] * determinante(nm);
        }
        return suma;
    }

    public static void imprime_matriz (double a [][], String cadena){
        System.out.println(cadena);
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print(Double.toString(a[i][j])+"  ");
            }
            System.out.println();
        }
    }

    public static void imprime_vector (double a [], String cadena){
        System.out.println(cadena);
        
            for(int j=0;j<a.length;j++){
                System.out.print(Double.toString(a[j])+"  ");
            }
            System.out.println();
        
    }

}