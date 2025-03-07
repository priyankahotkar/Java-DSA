import java.util.Scanner;

public class Arrays2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] arr = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // System.out.print("Enter element "+i+"row "+j+"column : ");
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter element to be searched : ");
        int x = sc.nextInt();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == x) {
                    System.out.println("The element is found at "+(i+1)+"row "+(j+1)+"column ");
                    break;
                }            
            }
        }
        System.out.println("Number is not found");
        sc.close();
    }
}
