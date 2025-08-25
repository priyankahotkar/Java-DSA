import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    public static int minRooms(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            if (arr[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(arr[i][1]);
        }

        return pq.size();
    }

    public static void main(String[] args) {
        int arr[][] = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println(minRooms(arr));
    }
}