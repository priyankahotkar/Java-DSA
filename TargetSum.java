public class TargetSum {
    public static boolean isTargetSum(int[] numbers, int target) {
        boolean[][] dp = new boolean[numbers.length+1][target+1];
        // i -> numbers
        // j -> remaining sum
        for (int i = 0; i < numbers.length+1; i++) {
            dp[i][0] = true;
            //dp[0][i] = false;
        }
        for (int i = 1; i < numbers.length+1; i++) {
           for (int j = 1; j < target+1; j++) {
                if (numbers[i-1] <= j && dp[i-1][j-numbers[i-1]] == true) {
                    dp[i][j] = true;
                }
                else if (dp[i-1][j] == true) {
                    dp[i][j] = true;
                }
           } 
        }
        printArr(dp);
        return dp[numbers.length][target];
    }
    public static void printArr(boolean[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {4,2,7,1,3};
        int sum = 10;
        System.out.println(isTargetSum(arr, sum));
    }
}
