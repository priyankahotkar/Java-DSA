import java.util.LinkedHashMap;
import java.util.HashMap;

public class Linkedhashmap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India",100);   //Implemented using array of doubly linked list
        lhm.put("China", 150);
        lhm.put("US", 50);

        System.out.println(lhm);

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India",100);
        hm.put("China", 150);
        hm.put("US", 50);

        System.out.println(hm);
    }
}
