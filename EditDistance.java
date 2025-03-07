public class EditDistance {
    public static int minOperations(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for (int j = 0; j < m+1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < n+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    int add = dp[i][j-1] + 1;
                    int del = dp[i-1][j] + 1;
                    int replace = dp[i-1][j-1] + 1;
                    int temp = Math.min(add, del);
                    dp[i][j] = Math.min(replace, temp);
                }
            }
        }
        return dp[n][m];
    }

    public static void noOfInsAndDel(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for (int j = 0; j < m+1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < n+1; i++) {
            dp[i][0] = i;
        }
        int insertOp = 0;
        int delOp = 0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    int add = dp[i][j-1] + 1;
                    int del = dp[i-1][j] + 1;
                    if (add < del) {
                        dp[i][j] = add;
                        insertOp++;
                    }
                    else {
                        dp[i][j] = del;
                        delOp++;
                    }
                }
            }
        }
        System.out.println("Insert operations = "+insertOp);
        System.out.println("Delete operations = "+delOp);
    }
    public static void main(String[] args) {
        String w1 = "intention";
        String w2 = "execution";
        System.out.println(minOperations(w1, w2));
        noOfInsAndDel(w1, w2);
    }
}
