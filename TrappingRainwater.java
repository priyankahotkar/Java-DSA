import java.util.Scanner;

public class TrappingRainwater {
    public static void trappedRainwater(int[] arr) {
        int totalVol = 0;
        for (int i = 1; i < arr.length-1; i++) {
            int leftMax = maxBoundary(arr, 0, i-1);
            int rightMax = maxBoundary(arr, i+1, arr.length-1);
            int waterLevel = Math.min(leftMax, rightMax);
            int trapwater = waterLevel - arr[i];
            totalVol += trapwater;
        }
        System.out.println(totalVol);
    }
    public static int maxBoundary(int[] arr, int start_index, int end_index) {
        int max_bound = Integer.MIN_VALUE;
        for (int i = start_index; i <= end_index; i++) {
            if (arr[i] > max_bound) {
                max_bound = arr[i];
            }
        }
        return max_bound;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt(); 
        int arr[] = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        trappedRainwater(arr);
    }
}
