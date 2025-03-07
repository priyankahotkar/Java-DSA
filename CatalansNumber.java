import java.util.Arrays;

public class CatalansNumber {
    public static int catRecursion(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int Cat = 0;
        for (int i = 0; i < n; i++) {
            Cat += catRecursion(i)*catRecursion(n-i-1);
        }
        return Cat;
    }
    public static int catMemoization(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int Cat = 0;
        for (int i = 0; i < n; i++) {
            Cat += catMemoization(i, dp)*catMemoization(n-i-1, dp);
        }
        return dp[n] = Cat;
    }
    // O(n*n)
    public static int catTabulation(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(catRecursion(n));
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(catMemoization(n, dp));
        System.out.println(catTabulation(n));
    }
}
