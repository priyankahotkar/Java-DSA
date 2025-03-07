import java.util.HashSet;

public class UnionIntersection {
    public static HashSet<Integer> union(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        return set;
    }

    public static HashSet<Integer> intersection(int[] arr1, int[] arr2) {   //O(n)
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) {
                result.add(arr2[i]);
            }
        }
        return result;
    }
    public static void main(String[] args) {    //O(n)
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};
        System.out.println("Union : "+union(arr1, arr2));
        System.out.println("Intersection : "+intersection(arr1, arr2));
    }
}
