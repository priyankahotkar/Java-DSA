import java.util.Scanner;

public class SubArrays {
    public static void subarrays(int[] arr) {
        int start, end , ts = 0;
        int max_sum = Integer.MIN_VALUE;
        int min_sum = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            start = i;
            for (int j = i; j < arr.length; j++) {
                end = j;
                int sum = 0;
                for (int j2 = start; j2 <= end; j2++) {
                    System.out.print(arr[j2]+" ");
                    sum += arr[j2];
                }
                System.out.println();
                System.out.println("Sum of subarray = "+sum);
                if (sum>max_sum) {
                    max_sum = sum;
                }
                if (sum<min_sum) {
                    min_sum = sum;
                }
                ts++;
            }
        }
        System.out.println("Total no of subarrays : "+ts);
        System.out.println("Maximum sum of subarrays is "+max_sum);
        System.out.println("Minimum sum of subarrays is "+min_sum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        subarrays(arr);
    }
}
