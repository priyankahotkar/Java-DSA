import java.io.*;
import java.util.*;
public class Arraylisthacclerank {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int d = sc.nextInt();
            for (int j = 1; j <= d; j++) {
                int k = sc.nextInt();
                list.add(k);
            }
            int q = sc.nextInt();
            for (int j = 1; j <= q; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                System.out.println(list.get(y));
            }
        }
        
    }
}
