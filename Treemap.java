import java.util.HashMap;
import java.util.TreeMap;

public class Treemap {
    public static void main(String[] args) {
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India",100);    //O(logn) for put, get, remove because of sorting
        tm.put("China", 150);   //Implemented using Red Black Trees
        tm.put("US", 50);
        tm.put("Indonesia", 6);

        System.out.println(tm);

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India",100);
        hm.put("China", 150);
        hm.put("US", 50);

        System.out.println(hm);
    }
}
