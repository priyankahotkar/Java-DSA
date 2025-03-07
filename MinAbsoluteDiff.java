import java.util.Arrays;

public class MinAbsoluteDiff {
    public static void main(String[] args) {    //O(nlogn)
        int A[] = {4,1,8,7};
        int B[] = {2,3,6,5};
        Arrays.sort(A);
        Arrays.sort(B);
        int absDif = 0;
        for (int i = 0; i < B.length; i++) {
            absDif += Math.abs(A[i]-B[i]);
        }
        System.out.println("Minimum Absolute Difference is "+absDif);
    }
}
