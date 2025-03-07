import java.util.ArrayList;
import java.util.List;

public class SumOfSubsets {
    
    public static void findSubsets(int[] arr, int targetSum) {
        List<Integer> currentSubset = new ArrayList<>();
        backtrack(arr, targetSum, 0, 0, currentSubset);
    }

    private static void backtrack(int[] arr, int targetSum, int currentIndex, int currentSum, List<Integer> currentSubset) {
        // Base Case: if the current sum is equal to the target sum, print the subset
        if (currentSum == targetSum) {
            System.out.println(currentSubset);
            return;
        }

        // If we've reached the end of the array or the sum exceeds the target, stop recursion
        if (currentIndex >= arr.length || currentSum > targetSum) {
            return;
        }

        // Include the current element in the subset
        currentSubset.add(arr[currentIndex]);
        backtrack(arr, targetSum, currentIndex + 1, currentSum + arr[currentIndex], currentSubset);

        // Backtrack: remove the last element added and try without including it
        currentSubset.remove(currentSubset.size() - 1);
        backtrack(arr, targetSum, currentIndex + 1, currentSum, currentSubset);
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int targetSum = 9;
        
        System.out.println("Subsets with sum " + targetSum + ":");
        findSubsets(arr, targetSum);
    }
}
