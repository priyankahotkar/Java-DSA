import java.util.PriorityQueue;

public class ConnectNRopes {
    public static int connectRopes(int[] ropes) {
        int cost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }
        while (pq.size() > 1) {
            int rope1 = pq.remove();
            int rope2 = pq.remove();
            int resRope = rope1 + rope2;
            cost += resRope;
            pq.add(resRope);
        }
        return cost;
    }
    public static void main(String[] args) {
        // int ropes[] = {4, 3, 2, 6};
        int ropes[] = {2, 3, 3, 4, 6};
        System.out.println(connectRopes(ropes));
    }
}
