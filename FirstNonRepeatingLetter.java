import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingLetter {
    public static void firstNonRepeatingLetter(String s) {
        int n = s.length();
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
            q.add(s.charAt(i));
            while (!q.isEmpty() && freq[q.peek() - 'a'] != 1) {
                q.poll();
            }
            if (!q.isEmpty()) {
                System.out.print(q.peek()+" ");
            } else {
                System.out.print(-1+" ");    
            }
        }
    }
    public static void main(String[] args) {
        firstNonRepeatingLetter("aabccxb");
    }
}
