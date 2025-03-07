public class MinArrayJumps {
    public static int minJumps(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[n-1] = 0;
        for (int i = n-2; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= arr[i] && (i+j) < n; j++) {
                dp[i] = Math.min(dp[i], dp[i+j]+1);
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        System.out.println(minJumps(arr));
    }
}
