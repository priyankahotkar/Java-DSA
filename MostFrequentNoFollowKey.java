import java.util.ArrayList;

public class MostFrequentNoFollowKey {
    public static int occurences(ArrayList<Integer> a, int key, int target) {
        int oc = 0;
        for (int i = 0; i < a.size()-1; i++) {
            if (a.get(i) == key && a.get(i+1) == target) {
                oc++;
            }
        }
        return oc;
    }
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(100);
        nums.add(200);
        nums.add(1);
        nums.add(100);
        System.out.println(occurences(nums, 1, 100));
    }
}
