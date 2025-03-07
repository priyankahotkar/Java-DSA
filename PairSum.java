import java.util.ArrayList;

public class PairSum {
    // brute force : O(n^2)
    public static boolean pairSum1(ArrayList<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i)+list.get(j) == target) {
                    return true;
                }
            }
        }
        return false;
    }
    
    // two pointer approach : O(n)
    public static boolean pairSum1withTwoPointer(ArrayList<Integer> list, int target) {
        int si = 0;
        int ei = list.size()-1;
        while (si<ei) {
            if (list.get(si)+list.get(ei) == target) {
                return true;
            }
            else if(list.get(si)+list.get(ei) < target) {
                si++;
            }
            else {
                ei--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        int target = 8;
        System.out.println(pairSum1withTwoPointer(l, target));
    }
}
