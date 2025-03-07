import java.util.HashMap;

public class TwoSum {
    public static int[] getIndices(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int remaining = target - arr[i];
            if (map.containsKey(remaining)) {
                return new int[]{map.get(remaining), i};
            }
            map.put(arr[i], i);
        }
        return null;
    }
    public static void main(String[] args) {
        //int[] arr = {2,7,11,15};
        int[] arr = {3,2,4};
        int ans[] = getIndices(arr, 6);
        System.out.println(ans[0]+" "+ans[1]);
    }
}
