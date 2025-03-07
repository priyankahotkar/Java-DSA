import java.util.ArrayList;

public class MonotonicArrayList {
    public static boolean isMonotonicallyIncreasing(ArrayList<Integer> a) {
        for (int i = 0; i < a.size()-1; i++) {
            if (a.get(i)>a.get(i+1)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(2);
        //a.add(4);
        //a.add(5);
        System.out.println(isMonotonicallyIncreasing(a));
    }
}
