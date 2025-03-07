import java.util.Arrays;

public class LongestCommonSubsequence {
    public static String commonSubsequence (String str1, String str2, int l1, int l2, String[][] dp) {
        if (l1 == 0 || l2 == 0) {
            return "";
        }
        if (!dp[l1][l2].equals("")) {
            return dp[l1][l2];
        }
        if (str1.charAt(l1-1) == str2.charAt(l2-1)) {
            dp[l1][l2] = commonSubsequence(str1, str2, l1-1, l2-1, dp) + str1.charAt(l1-1);
            return dp[l1][l2];
        }
        else {
            if (commonSubsequence(str1, str2, l1-1, l2, dp).length() > commonSubsequence(str1, str2, l1, l2-1, dp).length()) {
                dp[l1][l2] = commonSubsequence(str1, str2, l1-1, l2, dp);
                return dp[l1][l2];
            }
            else {
                return dp[l1][l2] = commonSubsequence(str1, str2, l1, l2-1, dp);
            }
        }
    }

    public static int commonSubsequenceLength(String str1, String str2, int l1, int l2) {
        if (l1 == 0 || l2 == 0) {
            return 0;
        }
        if (str1.charAt(l1-1) == str2.charAt(l2-1)) {
            return commonSubsequenceLength(str1, str2, l1-1, l2-1) + 1;
        }
        else {
            int ans1 = commonSubsequenceLength(str1, str2, l1-1, l2);
            int ans2 = commonSubsequenceLength(str1, str2, l1, l2-1);
            return Math.max(ans1, ans2);
        }
    }

    public static int commonSubsequenceLengthMemoization(String str1, String str2, int l1, int l2, int dp[][]) {
        if (l1 == 0 || l2 == 0) {
            return 0;
        }
        if (dp[l1][l2] != -1) {
            return dp[l1][l2];
        }
        if (str1.charAt(l1-1) == str2.charAt(l2-1)) {
            return dp[l1][l2] = commonSubsequenceLengthMemoization(str1, str2, l1-1, l2-1, dp) + 1;
        }
        else {
            int ans1 = commonSubsequenceLengthMemoization(str1, str2, l1-1, l2, dp);
            int ans2 = commonSubsequenceLengthMemoization(str1, str2, l1, l2-1, dp);
            return dp[l1][l2] = Math.max(ans1, ans2);
        }
    }

    public static int lcsTabulation(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        // initialization done implicitely
        // for (int i = 0; i < n+1; i++) {
        //     for (int j = 0; j < m+1; j++) {
        //         if (i == 0 || j == 0) {
        //             dp[i][j] = 0;
        //         }
        //     }
        // }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";
        int l1 = str1.length();
        int l2 = str2.length();
        int[][] dp = new int[l1+1][l2+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        String[][] dp2 = new String[l1+1][l2+1];
        for (int i = 0; i < dp2.length; i++) {
            Arrays.fill(dp2[i], "");
        }
        System.out.println(commonSubsequence(str1, str2, l1, l2, dp2));
        System.out.println(commonSubsequenceLengthMemoization(str1, str2, l1, l2, dp));
        System.out.println(lcsTabulation(str1, str2));
    }
}
