import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static int minTimeToRot(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
                else if (arr[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) {
            return 0;
        }
        
        int time = 0;
        while (!q.isEmpty() && freshOranges > 0) {
            int[] curr = q.remove();
            int x = curr[0];
            int y = curr[1];
            if (x-1 >= 0 && arr[x-1][y] == 1) {
                arr[x-1][y] = 2;
                freshOranges--;
                q.add(new int[]{x-1, y});
            }
            if (x+1 < arr.length && arr[x+1][y] == 1) {
                arr[x+1][y] = 2;
                freshOranges--;
                q.add(new int[]{x+1, y});
            }
            if (y-1 >= 0 && arr[x][y-1] == 1) {
                arr[x][y-1] = 2;
                freshOranges--;
                q.add(new int[]{x, y-1});
            }
            if (y+1 < arr[0].length && arr[x][y+1] == 1) {
                arr[x][y+1] = 2;
                freshOranges--;
                q.add(new int[]{x, y+1});
            }
            time++;
        }
        return freshOranges == 0 ? time : -1;
    }

    public static void main(String[] args) {
        // int arr[][] = { {2, 1, 0, 2, 1},{0, 0, 1, 2, 1},{1, 0, 0, 2, 1}};
        int arr[][] = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(minTimeToRot(arr));
    }
}
