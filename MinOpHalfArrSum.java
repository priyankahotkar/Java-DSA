import java.util.Comparator;
import java.util.PriorityQueue;

public class MinOpHalfArrSum { 

    public static int noOfOperations(int arr[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int originalsum = 0;
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            originalsum += arr[i];
        }
        int halfSum = originalsum/2;
        int noOfOps = 0;
        int sum = originalsum;
        while (!pq.isEmpty()) {
            int temp = pq.poll();
            pq.add(temp/2);
            noOfOps += 1;
            sum = (sum - temp) + temp/2;
            if (sum <= halfSum) {
                break;
            }
        }
        return noOfOps;
    }
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 19};
        System.out.println(noOfOperations(arr));
    }
}
