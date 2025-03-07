import java.util.Scanner;
// O(nlogn)
public class Mergesort {   //divide and conquer
    public static void divide(int[] arr, int start , int end) {
        if (start>=end) {
            return;
        }
        int mid = start + (end-start)/2 ;
        divide(arr, start, mid);
        divide(arr, mid+1, end);
        merge(arr,start,mid,end);
    }

    public static void merge(int[] arr, int si, int mid, int ei) {
        int temp[] = new int[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;
        while(i <= mid && j <= ei) {
            if (arr[i]<arr[j]) {
                temp[k++] = arr[i];
                i++;
            }
            else {
                temp[k++] = arr[j];
                j++;
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        for ( k = 0, i=si; k < temp.length; k++,i++) {
            arr[i] = temp[k];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
           arr[i] = sc.nextInt();
        }
        divide(arr, 0, size-1);
        for (int index = 0; index < arr.length; index++) {
            System.out.print(arr[index]+" ");
        }
        System.out.println();
        sc.close();
    }    
}
