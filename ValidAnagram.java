import java.util.HashMap;

public class ValidAnagram {
    public static boolean isAnagram(String w1, String w2) {   //O(n)
        if (w1 == null || w2 == null || w1.length() != w2.length()) {
            return false;
        }

        w1 = w1.toLowerCase().replaceAll("\\s+", "");
        w2 = w2.toLowerCase().replaceAll("\\s+", "");

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < w1.length(); i++) {
            map.put(w1.charAt(i), map.getOrDefault(w1.charAt(i), 0) + 1);
        }
        
        for (int i = 0; i < w2.length(); i++) {
            char ch = w2.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch)-1);
                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
            }
            else {
                return false;
            }
        }
        if (map.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("tulip", "lipid"));
    }
}
