import java.util.*;

public class AggressiveCows {
    // Helper function to check if a minimum distance is feasible
    private static boolean isFeasible(int[] stalls, int n, int c, int minDist) {
        int count = 1; // Place the first cow in the first stall
        int lastPosition = stalls[0];

        for (int i = 1; i < n; i++) {
            if (stalls[i] - lastPosition >= minDist) {
                count++;
                lastPosition = stalls[i];
                if (count == c) {
                    return true;
                }
            }
        }
        return false;
    }

    // Function to find the largest minimum distance
    private static int largestMinDistance(int[] stalls, int n, int c) {
        Arrays.sort(stalls); // Sort the stalls
        int low = 1; // Minimum possible distance
        int high = stalls[n - 1] - stalls[0]; // Maximum possible distance
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isFeasible(stalls, n, c, mid)) {
                result = mid; // Update result if feasible
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt();
            int c = sc.nextInt();
            int[] stalls = new int[n];

            for (int i = 0; i < n; i++) {
                stalls[i] = sc.nextInt();
            }

            System.out.println(largestMinDistance(stalls, n, c));
        }

        sc.close();
    }
}
