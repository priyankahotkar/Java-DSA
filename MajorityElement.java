import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MajorityElement {
    public static ArrayList<Integer> majorityElements(int[] nums) { //O(n)
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // if (hm.containsKey(nums[i])) {
            //     hm.put(nums[i], hm.get(nums[i])+1);
            // }
            // else {
            //     hm.put(nums[i], 1);
            // }
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        // Set<Integer> keySet = hm.keySet();
        int threshold = n/3;
        ArrayList<Integer> res = new ArrayList<>();
        for (Integer k : hm.keySet()) {
            if (hm.get(k) > threshold) {
                res.add(k);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        //int nums[] = {1, 2};
        System.out.println(majorityElements(nums));
    }
}
