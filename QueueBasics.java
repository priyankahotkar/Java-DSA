import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueBasics {
    // static class Queue {
    //     static int arr[];
    //     static int size;
    //     static int rear;

    //     Queue(int n) {
    //         arr = new int[n];
    //         size = n;
    //         rear = -1;
    //     }

    //     public static boolean isEmpty() {
    //         return rear == -1;
    //     }

    //     public static void add(int data) {
    //         if (rear == size - 1) {
    //             System.out.println("Queue is full");
    //             return;
    //         }

    //         rear = rear + 1;
    //         arr[rear] = data;
    //     }

    //     public static int remove() {
    //         if (isEmpty()) {
    //             System.out.println("Empty queue");
    //             return -1;
    //         }
    //         int front = arr[0];
    //         for (int i = 0; i < rear; i++) {
    //             arr[i] = arr[i+1];
    //         }
    //         rear--;
    //         return front;
    //     }

    //     public static int peek() {
    //         if (isEmpty()) {
    //             System.out.println("Empty queue");
    //             return -1;
    //         }
    //         return arr[0];
    //     }
    // }

    public static void main(String[] args) {
        // Queue<Integer> q = new LinkedList<>();
          //ArrayDeque (only 2 classes implement queue interface in Java they are LinkedList and ArrayDeque)
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
