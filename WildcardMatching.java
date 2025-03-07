public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        //initialize
        dp[0][0] = true;
        for (int i = 1; i < n+1; i++) {
            dp[i][0] = false;
        }
        for (int j = 1; j < m+1; j++) {
           if (p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1];
           }
           else {
                dp[0][j] = false;
           }
        }
        // bottom up fill dp array
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*') {
                    boolean ignore = dp[i][j-1];
                    boolean notignore = dp[i-1][j];
                    dp[i][j] = ignore || notignore;
                }
                else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String s = "baaabab";
        String p = "*****ba*****ab";
        System.out.println(isMatch("abc", "**d"));
    }
}
