public class PaintersPartition {
    public static boolean canBeColored(int mid, int n, int l, int r, int[] arr) {
        int currSum = 0;
        int partitions = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < l || arr[i] > r) {
                return false;
            }
            if (currSum + arr[i] < l || currSum + arr[i]> r) {
                partitions++;
                currSum = arr[i];
                if (partitions > n) {
                    return false;
                }
            }
            else {
                currSum += arr[i];
            }
        }
        return true;
    }

    public static int noOfWays(int n, int l, int r, int[] arr) {
        int res = 0;
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (canBeColored(mid, n, l, r, arr)) {
                res = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        int l = 3;
        int r = 12;
        int arr[] = {3, 5, 1, 2, 6};
        System.out.println(noOfWays(n, l, r, arr));
    }
}