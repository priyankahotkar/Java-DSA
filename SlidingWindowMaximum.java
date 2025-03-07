import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    static class Window implements Comparable<Window>{
        int element;
        int idx;

        public Window(int element, int idx) {
            this.element = element;
            this.idx = idx;
        }
        @Override
        public int compareTo(Window w) {
            return w.element - this.element;    //Max-Heap
        }
    }

    public static int[] slidingWindowMax(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            System.out.println("Invalid Input");
            return new int[0];
        }

        int[] wind = new int[arr.length-k+1];
        int j = 0;
        PriorityQueue<Window> pq = new PriorityQueue<>();
        int i = 0;
        for (; i < k; i++) {
            pq.add(new Window(arr[i], i));
        }
        wind[j++] = pq.peek().element;

        for (i = k; i < arr.length; i++) {  //O(nlogk)
            int curr = arr[i]; 
            while (!pq.isEmpty() && pq.peek().idx <= (i-k)) {
                pq.remove();
            }

            pq.add(new Window(curr, i));
            wind[j++] = pq.peek().element;
        }

        return wind;
    }
    public static void main(String[] args) {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int ans[] = slidingWindowMax(arr, 3);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
    }
}
