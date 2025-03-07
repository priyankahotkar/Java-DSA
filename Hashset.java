import java.util.HashSet;
import java.util.Iterator;
public class Hashset {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        System.out.println("Size of the set is "+set.size());
        System.out.println(set);
        // if (set.contains(1)) {
        //     System.out.println("Set contains 1");
        // }
        // if (!set.contains(6)) {
        //     System.out.println("Does not contain 6");
        // }
        // set.remove(1);
        // if (!set.contains(1)) {
        //     System.out.println("1 is deleted");
        // }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Object ele = it.next();
            System.out.print(ele);
        }
    }
}
