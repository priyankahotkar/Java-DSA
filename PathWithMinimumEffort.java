import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    static class Cell implements Comparable<Cell> {
        int row;
        int col;
        int val;

        public Cell(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        @Override
        public int compareTo(Cell c) {
            return this.val - c.val;  // Min-heap based on the cell value (effort)
        }
    }

    public static int minCostPath(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] minEffort = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        // Initialize the minEffort array with a large number
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                minEffort[i][j] = Integer.MAX_VALUE;
            }
        }

        // Priority queue to process cells in increasing order of their accumulated cost
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        pq.add(new Cell(0, 0, grid[0][0]));
        minEffort[0][0] = grid[0][0];

        // Directions (down, up, right, left)
        int[] dRow = {1, -1, 0, 0};
        int[] dCol = {0, 0, 1, -1};

        while (!pq.isEmpty()) {
            Cell curr = pq.poll();
            int r = curr.row, c = curr.col;

            // Skip if the cell is already visited
            if (visited[r][c]) continue;
            visited[r][c] = true;

            // If we've reached the bottom-right corner, return the minimum effort
            if (r == rows - 1 && c == cols - 1) {
                return minEffort[r][c];
            }

            // Explore all four possible directions
            for (int i = 0; i < 4; i++) {
                int newRow = r + dRow[i];
                int newCol = c + dCol[i];

                // Check if the new cell is valid and not visited
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]) {
                    // Calculate the new cost to reach the new cell
                    int newEffort = minEffort[r][c] + grid[newRow][newCol];

                    // If this path is better (less cost), update it and add to the queue
                    if (newEffort < minEffort[newRow][newCol]) {
                        minEffort[newRow][newCol] = newEffort;
                        pq.add(new Cell(newRow, newCol, newEffort));
                    }
                }
            }
        }

        return -1; // In case no path exists (shouldn't happen for valid input)
    }

    public static void main(String[] args) {
        int[][] grid = {
            {31, 100, 65, 12, 18},
            {10, 13, 47, 157, 6},
            {100, 113, 174, 11, 33},
            {88, 124, 41, 20, 140},
            {99, 32, 111, 41, 20}
        };

        int result = minCostPath(grid);
        System.out.println("Minimum Effort Path Sum: " + result);  // Output: 327
    }
}
