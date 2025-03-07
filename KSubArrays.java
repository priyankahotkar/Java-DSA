public class KSubArrays {
    public static int ans = 10000000;
    public static void solve(int arr[], int n, int k, int idx, int sum, int maxSum) {
        if (k == 1) {
            maxSum = Math.max(maxSum, sum);
            sum = 0;
            for (int i = idx; i < n; i++) {
                sum += arr[i];
            }
            maxSum = Math.max(maxSum, sum);
            ans = Math.min(ans, maxSum);
            return;
        }
        sum = 0;
        for (int i = idx; i < n; i++) {
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);
            solve(arr, n, k-1, i+1, 0, maxSum);
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int k = 3;
        int n = 4;
        solve(arr, n, k, 0, 0, 0);
        System.out.println(ans);
    }
}
