import java.util.ArrayList;
import java.util.Scanner;

public class Subsetsofnnaturalnos {
    public static void findSubsets (int n , ArrayList<Integer> subset) {
        if (n == 0) {
            printSubsets(subset);
            return;
        }
        //add hoga
        subset.add(n);
        findSubsets(n-1, subset);
        //add nhi hoga
        subset.remove(subset.size()-1);
        findSubsets(n-1, subset);
    }
    public static void printSubsets(ArrayList<Integer> subset) {
        for(int i=0; i<subset.size(); i++) {
            System.out.print(subset.get(i)+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> subset = new ArrayList<>();
        findSubsets(n, subset);
        sc.close();
    }
}
