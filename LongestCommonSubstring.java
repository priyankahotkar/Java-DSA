public class LongestCommonSubstring {
    public static int lcSubstringLength(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        int maxLength = 0;
        // initialization done implicitely
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < m+1; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxLength;
    }

    public static String lcSubstring(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        String[][] dp = new String[n+1][m+1];
        String lcs = "";
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = "";
        }
        for (int j = 0; j < m+1; j++) {
            dp[0][j] = "";
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + str1.charAt(i-1);
                    if (lcs.length() < dp[i][j].length()) {
                        lcs = dp[i][j];
                    }
                }
                else {
                    dp[i][j] = "";
                }
            }
        }
        return lcs;
    }
    public static void main(String[] args) {
        String str1 = "ABCDE";
        String str2 = "ABGCE";
        System.out.println(lcSubstringLength(str1, str2));
        System.out.println(lcSubstring(str1, str2));
    }
}
