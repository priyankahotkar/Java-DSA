public class RatinaMaze {
    public static int findWays(int current_x, int current_y, int n, int m, int[][] maze) {
        if (current_x == n-1 && current_y == m-1 && maze[current_x][current_y] == 1) {
            printMaze(maze);
            return 1;
        } else if (current_x == n || current_y == m || current_x < 0 || current_y < 0 || maze[current_x][current_y] == 0) {
            return 0;
        } else {
            maze[current_x][current_y] = 0; // Mark the current cell as visited by setting it to 0
            int w1 = findWays(current_x, current_y+1, n, m, maze);
            int w2 = findWays(current_x, current_y-1, n, m, maze);
            int w3 = findWays(current_x-1, current_y, n, m, maze);
            int w4 = findWays(current_x+1, current_y, n, m, maze);
            maze[current_x][current_y] = 1; // Reset the cell after exploring
            return w1 + w2 + w3 + w4;
        }
    }
    public static void printMaze(int[][] maze) {
        System.out.println("----------------Maze-------------------");
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };
        int n = maze.length;
        int m = maze[0].length;
        int ans = findWays(0, 0, n, m, maze);
        System.out.println(ans);
    }
}
