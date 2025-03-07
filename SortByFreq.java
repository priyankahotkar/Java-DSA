import java.util.TreeMap;

public class SortByFreq {
    public static String sortByFreq(String s) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        String res = "";
        for (Character key : map.keySet()) {
            for (int i = 0; i < map.get(key); i++) {
                res += key;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String input = "cccaaa";
        System.out.println(sortByFreq(input));
    }
}
