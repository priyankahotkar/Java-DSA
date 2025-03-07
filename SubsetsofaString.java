public class SubsetsofaString {
    //time complexity = O(n*2^n)
    //space complextity = O(n)
    public static void subSets (String s, int i, String ans) {
        if (i==s.length()) {
            System.out.println(ans);
            return;
        }
        char currChar = s.charAt(i);
        //to be
        subSets(s, i+1, ans+currChar); 
        //not to be
        subSets(s, i+1, ans);
    }
    public static void main(String[] args) {
        String s = "abc";
        subSets(s, 0, "");
    }
}
