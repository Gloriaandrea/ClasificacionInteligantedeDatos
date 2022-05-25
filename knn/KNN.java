package jade.src.knn;
import java.util.ArrayList;
import java.util.List;

public class KNN {
    private String y[]=dataset.get_Y();
    private double x[][]=dataset.get_X();
    public double alfa = 0.1;
    public double bactual[];
    public double bnueva[];
    public double error1;
    public double error2;
    public double xPrueba[]={5.2,3.1};
    public int cont=0;
    public boolean bandera=false;
    public instancia listDistances[];
    public double instNormal[];
    private double xNormalizado[][];
    public int k=4;
    public boolean empate=true;
    public String ganador;


    public static void execute(){
        helper.displayarEcuaciones();
        KNN knn=new KNN();
        knn.normalizar();
        knn.distancias();
        knn.ordenarDistancias();
        while (knn.empate){
            knn.getNeihgbors();
            if(knn.empate){
                knn.k++;
            }
        }
        
       knn.predecir();
    
    }

    public void normalizar(){
        
        xNormalizado=helper.normalizar(x);
        instNormal=helper.normalizarInst(xPrueba);
    }
    public void distancias(){
        listDistances=new instancia[y.length];
        double suma;
        
        for(int i =0;i<x.length;i++){
            
         suma=0;
            for(int j=0;j<x[0].length;j++){
                 suma+=Math.pow((xNormalizado[i][j]-instNormal[j]),2);
            }
            listDistances[i]=new instancia();
            listDistances[i].setDistance(Math.sqrt(suma));
            listDistances[i].setIndice(i);
        }
        
    }
    public void ordenarDistancias(){
        for(int i=1;i<x.length;i++){
            for(int j=0;j<x.length-i;j++){
                if(listDistances[j].getDistance()>listDistances[j+1].getDistance()){
                    instancia auxiliar=listDistances[j];
                    listDistances[j]=listDistances[j+1];
                    listDistances[j+1]=auxiliar;
                }
            }
            
        }
    }
    public void getNeihgbors(){
        //helper.getNeihbors(k);
        List <String> resultado= new ArrayList<String>();
        List <Integer> puntuacion=new ArrayList<Integer>();
        int max= 0;
        for(int i =0;i<k;i++){
            
            if (!resultado.contains(y[(int) listDistances[i].getIndice()])){
                resultado.add(y[(int) listDistances[i].getIndice()]);
                puntuacion.add(1);
            }else{
                puntuacion.set(resultado.indexOf(y[(int) listDistances[i].getIndice()]),(puntuacion.get(resultado.indexOf(y[(int) listDistances[i].getIndice()]))+1));
            }
        }
        
        
        for(int i =0; i<resultado.size();i++){

            if(puntuacion.get(i)>puntuacion.get(max)){
                max=i;
            }   
        }
        empate=false;
        ganador = y[max];
        for(int i =0; i<resultado.size();i++){

            if(puntuacion.get(i)==puntuacion.get(max)&& max!=i){
                empate=true;
            }   
        }


    }

    public void predecir(){
        System.out.println("La predicción de la clase de la instancia es "+ ganador);
    }
    
    
}
