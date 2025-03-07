public class MimumPartitioning {
    public static int minDiff(int numbers[]) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        int sum1 = ZeroOneKnapsack(numbers, sum);
        int sum2 = sum - sum1;
        return Math.abs(sum2-sum1);
    }

    public static int ZeroOneKnapsack(int[] numbers, int sum) {
        int n = numbers.length;
        int W = sum/2;
        int[][] dp = new int[n+1][W+1];
        // for (int i = 0; i < n+1; i++) {
        //     for (int j = 0; j < W+1; j++) {
        //         if (i == 0 || j == 0) {
        //             dp[i][j] = 0;
        //         }
        //     }
        // }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < W+1; j++) {
                if (numbers[i-1] <= j) {
                    int ans1 = numbers[i-1] + dp[i-1][j-numbers[i-1]];
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
    public static void main(String[] args) {
        int[] numbers = {2,-1,0,4,-2,-9};
        System.out.println(minDiff(numbers));
    }
}
