import java.util.Scanner;

public class Bubblesort {
    public static void bubbleSort(int arr[]){
        for (int turn = 0; turn < arr.length-1; turn++) {
            int swaps = 0 ;
            for(int j = 0;j<arr.length-1-turn;j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swaps++;
                }
            }
            if (swaps == 0) {
                System.err.println("It is a sorted array");
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        bubbleSort(arr);
        sc.close();
    }
}
