import java.util.ArrayList;

public class LonelyNumbers {
    public static boolean isFreqOne(ArrayList<Integer> a, int element) {
        // int si = 0;
        // int ei = a.size()-1;
        int count = 0;
        // while (si<ei) {
        //     if (a.get(si)==element) {
        //         count++;
        //         si++;
        //     }
        //     if (a.get(ei)==element) {
        //         count++;
        //         ei--;
        //     }
        //     else {
        //         si++;
        //         ei--;
        //     }
        // }
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == element) {
                count++;
            }
        }
        if (count == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean search(ArrayList<Integer> a, int element) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == element) {
                return true;
            }
        }
        return false;
    }
    public static ArrayList<Integer> retLonelyNos(ArrayList<Integer> a) {
        ArrayList<Integer> r = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            int x = a.get(i);
            if (isFreqOne(a, x) && !search(a,x-1) && !search(a, x+1)) {
                r.add(x);
            }
        }
        return r;
    }
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(3);
        al.add(5);
        al.add(3);
        System.out.println(retLonelyNos(al));
    }
}
