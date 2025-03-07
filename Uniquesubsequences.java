import java.util.HashSet;

public class Uniquesubsequences {
    public static void subSequences (String s, int i, String newString , HashSet<String> set) {
        if (i==s.length()) {
            if (set.contains(newString)) {
                return;
            }
            System.out.println(newString);
            set.add(newString);
            return;
        }
        char currChar = s.charAt(i);
        //to be
        subSequences(s, i+1, newString+currChar, set);
        //not to be
        subSequences(s, i+1, newString, set);
    }
    public static void main(String[] args) {
        String s = "aaa";
        HashSet<String> set = new HashSet<>();
        subSequences(s, 0, "",set);
    }
}
