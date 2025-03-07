public class SizeOfLargestRegion {
    public static int largestMatrix(int[][] arr) {
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int si = 0;
                if (arr[i][j] == 1) {
                    si++;
                    if (i-1 >= 0 && arr[i-1][j] == 1) {
                        si++;
                    }
                    if (i+1 < arr.length && arr[i+1][j] == 1) {
                        si++;
                    }
                    if (j-1 >= 0 && arr[i][j-1] == 1) {
                        si++;
                    }
                    if (j+1 < arr[0].length && arr[i][j+1] == 1) {
                        si++;
                    }
                    if (i-1 >= 0 && j-1 >= 0 && arr[i-1][j-1] == 1) {
                        si++;
                    }
                    if (i-1 >= 0 && j+1 < arr[0].length && arr[i-1][j+1] == 1) {
                        si++;
                    }
                    if (i+1 < arr.length && j+1 < arr[0].length && arr[i+1][j+1] == 1) {
                        si++;
                    }
                    if (i+1 < arr.length && j-1 >= 0 && arr[i+1][j-1] == 1) {
                        si++;
                    }
                }
                s = Math.max(s, si);
            }
        }
        return s;
    }
    public static void main(String[] args) {
        int arr[][] = { {0, 0, 1, 1, 0}, {0, 0, 1, 1, 0},{0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}};
        System.out.println(largestMatrix(arr));
    }
}
