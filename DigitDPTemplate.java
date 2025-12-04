import java.util.Arrays;

public class DigitDPTemplate {
    long[][][][] dp;
    char[] s;
    int mod = 1000000007;

    public int countInRange(String low, String high) {
        String lowMinus = minusOne(low);
        long right = solve(high) % mod;

        if (lowMinus.equals("0"))
            return (int) right;

        long left = solve(lowMinus) % mod;
        return (int) ((right - left + mod) % mod);
    }

    public String minusOne(String x) {
        char[] arr = x.toCharArray();
        int i = arr.length - 1;

        while (i >= 0) {
            if (arr[i] > '0') {
                arr[i]--;
                break;
            }
            arr[i] = '9';
            i--;
        }
        if (i < 0)
            return "0";

        int start = 0;
        while (start < arr.length - 1 && arr[start] == '0')
            start++;

        return new String(arr, start, arr.length - start);
    }

    public long solve(String num) {
        s = num.toCharArray();
        int n = s.length;

        dp = new long[n + 1][2][2][10];

        for (long[][][] a : dp)
            for (long[][] b : a)
                for (long[] c : b)
                    Arrays.fill(c, -1);

        return dfs(0, 1, 0, 0);
    }

    public long dfs(int idx, int tight, int started, int customState) {
        if (idx == s.length)
            return started == 1 ? 1 : 0;

        if (dp[idx][tight][started][customState] != -1)
            return dp[idx][tight][started][customState];

        int limit = tight == 1 ? s[idx] - '0' : 9;
        long ans = 0;

        for (int d = 0; d <= limit; d++) {
            int nTight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0) {
                if (d == 0) {
                    ans = (ans + dfs(idx + 1, nTight, 0, customState)) % mod;
                } else {
                    ans = (ans + dfs(idx + 1, nTight, 1, d)) % mod;
                }
            } else {
                if (Math.abs(customState - d) == 1)
                    ans = (ans + dfs(idx + 1, nTight, 1, d)) % mod;
            }
        }

        dp[idx][tight][started][customState] = ans;
        return ans;
    }
}
