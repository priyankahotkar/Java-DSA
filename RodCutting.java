public class RodCutting {
    public static int maxRodval(int[] lengths, int[] price, int rodLength) {
        int[][] dp = new int[price.length+1][rodLength+1];
        // initialization done implicitely
        for (int i = 1; i < price.length+1; i++) {
            for (int j = 1; j < rodLength+1; j++) {
                if (lengths[i-1] <= j) {
                    int v1 = price[i-1] + dp[i][j-lengths[i-1]];
                    int v2 = dp[i-1][j];
                    dp[i][j] = Math.max(v1, v2);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[price.length][rodLength];
    }

    public static void main(String[] args) {
        int[] lengths = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(maxRodval(lengths, price, 8));
    }
}
