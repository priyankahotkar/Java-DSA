public class PermutationsOfString {
    public static void findPermutations(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }
        //Time complexity : O(n*n!)
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            String new_s = s.substring(0, i) + s.substring(i+1);
            findPermutations(new_s, ans+curr);
        }
    }
    public static void main(String[] args) {
        String str = "abc";
        findPermutations(str, "");
    }
}
