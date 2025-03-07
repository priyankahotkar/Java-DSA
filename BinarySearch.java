import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter element to be searched : ");
        int key = sc.nextInt();
        int x = getIndex(arr,key,0,arr.length-1);
        System.out.println(x);
    }
    public static int getIndex(int[] arr,int key,int start,int end) {
        if (start>end) {
            return -1;
        }
        int mid = (start+end)/ 2;
        if (arr[mid] == key) {
            return mid;
        }
        else if(key<arr[mid]) {
            return getIndex(arr, key, start, mid-1);
        }
        else {
            return getIndex(arr, key, mid+1, end);
        }
    }
}
