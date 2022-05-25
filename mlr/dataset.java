package jade.src.mlr;

public class dataset {
    public static double[][] get_X() {
        double[][] x = {
        {1,  1,  23},
        {1,  2,  26},
        {1,  3,  30},
        {1,  4,  34},
        {1,  5,  43},
        {1,  6,  48},
        {1,  7,  52},
        {1,  8,  57},
        {1,  9,  58},
        
    };
        return x;
    }

    public static double[] get_Y() {
        double[] y = {651,  762,  856,  1063, 1190, 1298, 1421, 1440, 1518};
           
        return y;
    }
}
