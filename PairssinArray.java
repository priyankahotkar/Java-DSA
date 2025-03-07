import java.util.Scanner;

public class PairssinArray {
    public static void pairsArray(int[] arr){
        int tp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                System.out.print("("+arr[i]+", "+arr[j]+")  ");
                tp++;
            }
            System.out.println();
        }
        System.out.println("Total no. of pairs = "+tp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        pairsArray(arr);
    }
}
