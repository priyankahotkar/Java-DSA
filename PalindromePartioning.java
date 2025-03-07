import java.util.*;

public class PalindromePartioning {
    public static List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        // Fill the DP table
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 1 || len == 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result, dp);
        return result;
    }

    private static void backtrack(String s, int idx, List<String> path, List<List<String>> result, boolean[][] dp) {
        if (idx == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = idx; i < s.length(); i++) {
            if (dp[idx][i]) {
                path.add(s.substring(idx, i + 1));
                backtrack(s, i + 1, path, result, dp);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> partitions = partition(s);
        
        System.out.println("Palindrome Partitions:");
        for (List<String> partition : partitions) {
            System.out.println(partition);
        }
    }
}
