class Solution5 {
    private static final int MOD = 1_000_000_007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        // DP table: dp[remaining moves][row][col]
        int[][][] dp = new int[maxMove + 1][m][n];

        // Directions array: Up, Down, Left, Right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int result = 0;

        // Iterate over each move count
        for (int moves = 1; moves <= maxMove; moves++) {
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    // Check all 4 directions
                    for (int[] dir : directions) {
                        int newRow = row + dir[0];
                        int newCol = col + dir[1];

                        // If the ball moves out of bounds, count this path
                        if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                            dp[moves][row][col] += 1;
                        } else {
                            // Otherwise, accumulate paths from the previous move
                            dp[moves][row][col] += dp[moves - 1][newRow][newCol];
                        }

                        // Apply modulo to prevent overflow
                        dp[moves][row][col] %= MOD;
                    }
                }
            }
        }

        // Sum up all paths from all possible moves
        for (int moves = 1; moves <= maxMove; moves++) {
            result += dp[moves][startRow][startColumn];
            result %= MOD;
        }

        return result;
    }

    // Test the solution
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findPaths(2, 2, 2, 0, 0));  // Output: 6
        System.out.println(solution.findPaths(1, 3, 3, 0, 1));  // Output: 12
    }
}
