public class DiagonalMatrix {
    public static int diagonalSum(int[][] matrix) {
        int sum = 0;
        int n = matrix.length;
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (i == j) {
        //             sum += matrix[i][j];
        //         }
        //         if (i == n-j-1 && i != j) {
        //             sum += matrix[i][j];
        //         }
        //     }
        // }

        for (int i = 0; i < n; i++) {
            sum+= matrix[i][i];
            if (i != n-i-1) {
                sum += matrix[i][n-i-1];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}};
        System.out.println(diagonalSum(matrix));
    }
}
