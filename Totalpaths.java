import java.util.Scanner;

public class Totalpaths {
    public static int countPaths (int i,int j,int n ,int m) {
        if (i == n || j == m) {
            return 0;
        }
        if (i == n-1 && j == m-1) {
            return 1;
        }
        //move downwards
        int downPaths = countPaths(i+1, j, n, m);
        //move right
        int rightPaths = countPaths(i, j+1, n, m);
        return downPaths + rightPaths ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter initial x co-ordinate : ");
        int i = sc.nextInt();
        System.out.print("Enter initial y co-ordinate : ");
        int j = sc.nextInt();
        System.out.print("Enter final x co-ordinate : ");
        int n = sc.nextInt();
        System.out.print("Enter final y co-ordinate : ");
        int m = sc.nextInt();
        System.out.println("Total paths = "+countPaths(i, j, n, m));
        sc.close();
    }
}
