import java.util.HashMap;

public class SubarraySumK {
//     Use a HashMap (map) to store the cumulative sum and its frequency. This helps in reducing the complexity of finding subarrays.
// Keep track of the cumulative sum (sum) as you iterate over the array.
// At each step, check if (sum - k) exists in the map:
// If it exists, it means there are subarrays ending at the current index whose sum equals 
// 𝑘
// k. Increment ans by the frequency of (sum - k).
// Update the map with the current sum.

    public static int countSubArray(int[] arr, int k) { //O(n)
        HashMap<Integer, Integer> map = new HashMap<>();    //(sum, count)
        int sum = 0;
        int ans = 0;
        map.put(0, 1);
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];  //sum(j)
            if (map.containsKey(sum-k)) {
                ans += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {10, 2, -2, -20, 10};
        System.out.println(countSubArray(arr, -10));
    }
}
