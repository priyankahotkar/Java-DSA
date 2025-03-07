import java.util.Scanner;

public class Quicksort {    //Pivot and Partition
    public static void quickSorting(int[] arr, int si, int ei) {
        if (si>=ei) {
            return;
        }
        int pidx = partition(arr,si,ei);
        quickSorting(arr, si, pidx-1);
        quickSorting(arr, pidx+1, ei);

    }
    public static int partition(int arr[] , int si, int ei) {
        int pivot = arr[ei];
        int i = si-1; //to make place for elements smaller than pivot
        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }                  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
           arr[i] = sc.nextInt(); 
        }
        quickSorting(arr, 0, size-1);
        for (int index = 0; index < arr.length; index++) {
            System.out.print(arr[index]+" ");
        }
        System.out.println();
        sc.close();
    }
}
