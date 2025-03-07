import java.util.HashSet;

public class CountDistinctElements {
    public static int countDistinctElements(int arr[]) {    //O(n)
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            // if (set.contains(arr[i])) {
            //     set.remove(arr[i]);
            // }
            // else {
            //     set.add(arr[i]);
            // }
            set.add(arr[i]);
        }
        return set.size();
    }
    public static void main(String[] args) {
        int num[] = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};
        System.out.println(countDistinctElements(num));
    }
}
