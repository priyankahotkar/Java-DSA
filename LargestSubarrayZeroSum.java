import java.util.HashMap;

public class LargestSubarrayZeroSum {
    public static int largestSubArray(int arr[]) {  //O(n)
        int ansLen = 0;
        int subArrayLen = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();    //sum, idx
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (map.containsKey(sum)) {
                subArrayLen = j - map.get(sum);
                ansLen = Math.max(ansLen, subArrayLen);
            }
            else {
                map.put(sum, j);
            }
        }
        return ansLen;
    }
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(largestSubArray(arr));
    }
}
