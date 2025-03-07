import java.util.*;
public class Negativesubarrays {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        sumOfArray(arr,arr.length,0,0);
    }
    public static int sumOfArray(int[] arr,int size,int c,int index) {
        if(size == -1) {
            return c;
        }
        int sum = 0;
        for(int i =index;i<size+index;i++) {
           sum+=arr[i]; 
        }
        if(sum < 0) {
            c+=1;
        }
        sumOfArray(arr,arr.length-1,c,index+1);
        return c;
    }
    
}

