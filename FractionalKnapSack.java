import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapSack {
    public static void main(String[] args) {
        int val[] = {50, 80, 100};
        int weight[] = {10, 20, 30};
        int W = 50;
        double[] fractions = new double[val.length];
        DecimalFormat df = new DecimalFormat("#.##");

        double ratio[][] = new double[val.length][2];
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)weight[i];
        }
        //ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        int finalVal = 0;
        for(int i = ratio.length-1; i>=0; i--) {
            int idx = (int)ratio[i][0];
            if (capacity >= weight[idx]) {  //include full item
                capacity -= weight[idx];
                finalVal += val[idx];
                fractions[idx] = 1;
            } else {                        //include fractional item
                finalVal += ( ratio[i][1] * capacity);
                fractions[idx] = capacity/(double)weight[idx];
                capacity = 0;
                break;
            }
        }
        System.out.println("Final value = "+ finalVal);
        for (int i = 0; i < fractions.length; i++) {
            System.out.print(df.format(fractions[i])+", ");
        }
    }
}
