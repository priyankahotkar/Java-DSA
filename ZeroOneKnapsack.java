import java.util.Arrays;

public class ZeroOneKnapsack {
    // O(n * W)
    public static int recursionKnapSack(int val[], int wt[], int W, int n, int dp[][]) {
        if (W == 0 || n == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        if (wt[n-1] <= W) {     // 1st item - index 0
            int ans1 = val[n-1] + recursionKnapSack(val, wt, W-wt[n-1], n-1, dp);
            int ans2 = recursionKnapSack(val, wt, W, n-1, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        }
        else {
            dp[n][W] = recursionKnapSack(val, wt, W, n-1, dp);
            return dp[n][W];
        }
    }

    public static int tabulationKnapSack(int val[], int wt[], int W, int n) {
        int[][] dp = new int[n+1][W+1];
        // i -> items
        // j -> remaining weight
        for (int i = 0; i < wt.length; i++) {
            dp[0][i] = 0;
            dp[i][0] = 0;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < W+1; j++) {
                if (wt[i-1] <= j) {
                    int pf1 = val[i-1] + dp[i-1][j-wt[i-1]];
                    int pf2 = dp[i-1][j];
                    dp[i][j] = Math.max(pf1, pf2);
                }
                else {
                    int pf2 = dp[i-1][j];
                    dp[i][j] = pf2;
                }
            }
        }
        return dp[n][W];
    }

    public static int unboundedKnapSack(int val[], int wt[], int W, int n) {
        int[][] dp = new int[n+1][W+1];
        // i -> items
        // j -> remaining weight
        for (int i = 0; i < wt.length; i++) {
            dp[0][i] = 0;
            dp[i][0] = 0;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < W+1; j++) {
                if (wt[i-1] <= j) {
                    int pf1 = val[i-1] + dp[i][j-wt[i-1]];
                    int pf2 = dp[i-1][j];
                    dp[i][j] = Math.max(pf1, pf2);
                }
                else {
                    int pf2 = dp[i-1][j];
                    dp[i][j] = pf2;
                }
            }
        }
        return dp[n][W];
    }
    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        int dp[][] = new int[val.length+1][W+1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        System.out.println("Memoization output : "+recursionKnapSack(val, wt, W, val.length, dp));
        System.out.println("Tabulation output : "+tabulationKnapSack(val, wt, W, val.length));
        // System.out.println(unboundedKnapSack(val, wt, W, val.length));
    }
}
