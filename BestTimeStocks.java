import java.util.Arrays;
import java.util.Comparator;

public class BestTimeStocks {
    public static void main(String[] args) {
        int prices[] = {7,6,4,3,1};   //1,3,4,5,6,7 -> 2,4,6,3,5,1
        int arr[][] = new int[prices.length][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = i+1;  //days
            arr[i][1] = prices[i];
        }
        Arrays.sort(arr, Comparator.comparingDouble(o -> o[1]));
        int buy = 0;
        int sell = 0;
        int profit = 0;
        buy += arr[0][1];
        int boughtDay = arr[0][0];
        int soldDay = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            if (buy <= arr[i][1] && boughtDay < arr[i][0]) {
                soldDay = arr[i][0];
                sell += arr[i][1];
                profit += arr[i][1] - buy;
                buy = 0;
            }
            if (buy == 0) {
                buy += arr[i][1];
                boughtDay = arr[i][0];
            }
        }
        System.out.println(profit);
    }
}
