import java.util.*;

public class AmazonOAPractice {
    private long totalCost; // Tracks total swap cost
    private int[] weights; // Original weights array
    private int[] priorities; // Original priorities array
    private int[] indices; // Tracks indices during merge sort
    private int[] temp; // Temporary array for merge sort

    public long minEnergyCost(int n, int[] weights, int[] priorities) {
        this.weights = weights;
        this.priorities = priorities;
        this.totalCost = 0;
        this.indices = new int[n];
        this.temp = new int[n];

        // Initialize indices array
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Perform merge sort on indices array to count inversions and compute cost
        mergeSort(0, n - 1);

        return totalCost;
    }

    private void mergeSort(int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);
    }

    private void merge(int left, int mid, int right) {
        // Copy indices to temp array
        for (int i = left; i <= right; i++) {
            temp[i] = indices[i];
        }

        int i = left; // Left subarray pointer
        int j = mid + 1; // Right subarray pointer
        int k = left; // Merged array pointer

        while (i <= mid && j <= right) {
            // Compare priorities of packages at temp[i] and temp[j]
            if (priorities[temp[i]] <= priorities[temp[j]]) {
                indices[k++] = temp[i++];
            } else {
                // Inversion: temp[j] needs to move before temp[i..mid]
                indices[k++] = temp[j++];
                // Each inversion corresponds to a swap with all elements from i to mid
                for (int p = i; p <= mid; p++) {
                    totalCost += (long) weights[temp[p]] + weights[temp[j - 1]];
                }
            }
        }

        // Copy remaining elements from left subarray
        while (i <= mid) {
            indices[k++] = temp[i++];
        }
    }

    public static void main(String[] args) {
        AmazonOAPractice sol = new AmazonOAPractice();

        // Test Case 1: Small Input
        int n1 = 3;
        int[] weights1 = { 2, 3, 4 };
        int[] priorities1 = { 3, 1, 2 };
        System.out.println("Test Case 1: " + sol.minEnergyCost(n1, weights1, priorities1)); // Expected: 5

        // Test Case 2: Reverse Order
        int n2 = 4;
        int[] weights2 = { 1, 2, 3, 4 };
        int[] priorities2 = { 4, 3, 2, 1 };
        System.out.println("Test Case 2: " + sol.minEnergyCost(n2, weights2, priorities2)); // Expected: 12

        // Test Case 3: Already Sorted
        int n3 = 3;
        int[] weights3 = { 1, 2, 3 };
        int[] priorities3 = { 1, 2, 3 };
        System.out.println("Test Case 3: " + sol.minEnergyCost(n3, weights3, priorities3)); // Expected: 0

        // Test Case 4: Duplicate Priorities
        int n4 = 4;
        int[] weights4 = { 2, 3, 4, 5 };
        int[] priorities4 = { 2, 2, 1, 1 };
        System.out.println("Test Case 4: " + sol.minEnergyCost(n4, weights4, priorities4)); // Expected: 14

        // Test Case 5: Large Input
        int n5 = 6;
        int[] weights5 = { 1000, 2000, 3000, 4000, 5000, 6000 };
        int[] priorities5 = { 600, 500, 400, 300, 200, 100 };
        System.out.println("Test Case 5: " + sol.minEnergyCost(n5, weights5, priorities5)); // Expected: 45000

        // Test Case 6: Single Package
        int n6 = 1;
        int[] weights6 = { 100 };
        int[] priorities6 = { 50 };
        System.out.println("Test Case 6: " + sol.minEnergyCost(n6, weights6, priorities6)); // Expected: 0
    }
}