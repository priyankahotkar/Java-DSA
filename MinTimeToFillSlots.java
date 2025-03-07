import java.util.PriorityQueue;

public class MinTimeToFillSlots {
    static class Slot implements Comparable<Slot> {
        int idx;
        int distance;
        public Slot(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }

        @Override
        public int compareTo(Slot s) {
            return this.distance - s.distance;
        }
    }

    public static int minTime(int N, int K, int arr[]) {
        PriorityQueue<Slot> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];

        for (int i = 0; i < arr.length; i++) {
            pq.add(new Slot(arr[i], 0));
            visited[arr[i]] = true;
        }

        int maxTime = 0;

        while (!pq.isEmpty()) {
            Slot curr = pq.peek();
            pq.remove();

            maxTime = Math.max(maxTime, curr.distance);

            if (curr.idx - 1 >= 1 && !visited[curr.idx-1]) {
                pq.add(new Slot(curr.idx-1, curr.distance+1));
                visited[curr.idx-1] = true;
            }
            if (curr.idx + 1 <= N && !visited[curr.idx+1]) {
                pq.add(new Slot(curr.idx+1, curr.distance+1));
                visited[curr.idx+1] = true;
            }
        }
        return maxTime;
    }

    public static void main(String[] args) {
        System.out.println(minTime(5, 5, new int[]{1, 2, 3, 4, 5}));
        System.out.println(minTime(6, 2, new int[]{2, 6})); 
    }
}
