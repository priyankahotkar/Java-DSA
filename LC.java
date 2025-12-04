class LC {
    int[][] directions = { { 0, 1 }, { 1, 0 } };

    public int maxPathScore(int[][] grid, int k) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0, getCost(grid, 0, 0) });

        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int ki = 0; ki <= k; ki++) {
                    dp[i][j][ki] = -1;
                }
            }
        }

        dp[0][0][getCost(grid, 0, 0)] = getSc(grid, 0, 0);

        while (!q.isEmpty()) {
            int[] curr = q.remove();
            int x = curr[0], y = curr[1];
            int used = curr[2];

            for (int[] dir : directions) {
                int nx = dir[0] + x, ny = dir[1] + y;

                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                int ncost = used + getCost(grid, nx, ny);
                if (ncost > k)
                    continue;

                int nscore = dp[x][y][used] + getSc(grid, nx, ny);

                if (nscore > dp[nx][ny][ncost]) {
                    dp[nx][ny][ncost] = nscore;
                    q.add(new int[] { nx, ny, ncost });
                }
            }
        }

        int ans = -1;
        for (int c = 0; c <= k; c++) {
            ans = Math.max(ans, dp[n - 1][m - 1][c]);
        }

        return Math.max(-1, ans);
    }

    public int getSc(int[][] grid, int i, int j) {
        if (grid[i][j] == 0)
            return 0;

        else if (grid[i][j] == 1)
            return 1;

        return 2;
    }

    public int getCost(int[][] grid, int i, int j) {
        if (grid[i][j] == 0)
            return 0;

        return 1;
    }
}