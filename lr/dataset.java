package jade.src.lr;

public class dataset {
    public static double[][] get_X() {
        double[][] x = {
        {1,  1, 1},
        {1,  4, 2},
        {1,  2, 4}
        
    };
        return x;
    }

    public static double[] get_Y() {
        double[] y = {0, 1, 1};
        return y;
    }
    
}
