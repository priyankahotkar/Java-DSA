import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    public static void kthLargestElement(int stream[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < stream.length; i++) {
            pq.add(stream[i]);
            if (pq.size() > k) {
                pq.poll();
            }
            if (pq.size() == k) {
                System.out.print(pq.peek()+" ");
            }
        }
    }
    public static void main(String[] args) {
        int[] stream = {10, 20, 11, 70, 50, 40, 100, 5};
        kthLargestElement(stream, 3);
    }
}
