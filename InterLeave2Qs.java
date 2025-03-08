import java.util.LinkedList;
import java.util.Queue;

public class InterLeave2Qs {
    public static void interleave(Queue<Integer> q) {
        Queue<Integer> first = new LinkedList<>();
        int size = q.size();
        int i = 0;
        while (i < size/2) {
            first.add(q.remove());
            i++;
        }
        while (!first.isEmpty()) {
            q.add(first.remove());
            q.add(q.remove());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        interleave(q);
        System.out.println(q);
    }
}
