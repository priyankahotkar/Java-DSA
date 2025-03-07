import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IndianCoins {
    public static void main(String[] args) {
        Integer[] coins = {1,100,500,20,5,2,2000,50,10};
        int amount = 1059;
        int count = 0;
        Arrays.sort(coins, Comparator.reverseOrder());
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                while (coins[i] <= amount) {
                    count++;
                    amount -= coins[i];
                    ans.add(coins[i]);
                }
            }
        }
        System.out.println("Number of coins = "+count);
        System.out.println(ans);
    }
}
