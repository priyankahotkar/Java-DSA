import java.util.*;
public class ArrayListSort {
    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(6);
        l.add(1);
        l.add(5);
        l.add(4);
        l.add(2);
        System.out.println(l);
        Collections.sort(l);    //ascending
        System.out.println(l);

        Collections.sort(l, Collections.reverseOrder()); //descending
        //Comparator - fnx logic
        System.out.println(l);
    }
}
