import java.util.Scanner;

public class PrefixArray {
    public static void calcPrefixArray(int[] arr,int startIdx , int endIdx) {
        int pa[] = new int[arr.length];
        int sum = 0;
        pa[0] = arr[0];
        for (int i = 1; i < pa.length; i++) {
            pa[i] = pa[i-1]+arr[i];
        }
        sum = pa[endIdx] - pa[startIdx-1];
        System.out.println(sum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt(); 
        int arr[] = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        calcPrefixArray(arr, 1, 3);
    }
}
