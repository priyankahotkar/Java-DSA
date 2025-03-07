import java.util.LinkedList;
import java.util.Queue;

public class DesignHitCounter {
    static class HitCounter {
        private Queue<Integer> queue;

        public HitCounter() {
            queue = new LinkedList<>();
        }
        void hit(int timestamp) {
            queue.add(timestamp);
        }
        int getHits(int timestamp) {
            while (!queue.isEmpty() && queue.peek() >= 300) {
                queue.remove();
            }
            return queue.size();
        }
    }
    public static void main(String[] args) {
        HitCounter counter = new HitCounter();
        
        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        System.out.println(counter.getHits(4));  // Output: 3
        
        counter.hit(300);
        System.out.println(counter.getHits(300));  // Output: 4
        
        System.out.println(counter.getHits(301));  // Output: 3
    }
}