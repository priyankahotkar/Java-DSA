import java.util.ArrayList;

public class PairSum2 {
    // two pointer approach O(n)
    public static boolean pairSum2(ArrayList<Integer> l, int target) {
        int i = 0;
        while (l.get(i)<l.get(i+1) && i<l.size()-1) {
            i++;
        }
        int lp = i+1;   //smallest 
        int rp = i;     //largest
        while (lp != rp) {
            if (l.get(lp)+l.get(rp) == target) {
                return true;
            }
            else if (l.get(lp)+l.get(rp) < target) {
                lp = (lp + 1)%(l.size());
            }
            else {
                rp = (rp - 1 + l.size())%(l.size());
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(11);
        l.add(15);
        l.add(6);
        l.add(8);
        l.add(9);
        l.add(10);
        System.out.println(pairSum2(l, 100));
    }
}
