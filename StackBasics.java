import java.util.ArrayList;
import java.util.Stack;

public class StackBasics {
    // static class Stack {
    //     static ArrayList<Integer> list = new ArrayList<>();

    //     public static boolean isEmpty() {
    //         return list.size() == 0;
    //     }

    //     public static void push(int data) {
    //         list.add(data);
    //     }

    //     public static int pop() {
    //         if (isEmpty()) {
    //             return -1;
    //         }
    //         int top = list.get(list.size()-1);
    //         list.remove(list.size()-1);
    //         return top;
    //     }

    //     public static int peek() {
    //         if (isEmpty()) {
    //             return -1;
    //         }
    //         return list.get(list.size()-1);
    //     }
    // }

    // static class Node {
    //     int data;
    //     Node next;

    //     public Node(int data) {
    //         this.data = data;
    //         this.next = null;
    //     }
    // }

    // static class Stack {
    //     static Node head = null;

    //     public static boolean isEmpty() {
    //         return head == null;
    //     }

    //     public static void push(int data) {
    //         if (isEmpty()) {
    //             head = new Node(data);
    //             return;
    //         }
    //         Node temp = new Node(data);
    //         temp.next = head;
    //         head = temp;
    //     }

    //     public static int pop() {
    //         if (isEmpty()) {
    //             return -1;
    //         }
    //         int top = head.data;
    //         head = head.next;
    //         return top;
    //     }

    //     public static int peek() {
    //         if (isEmpty()) {
    //             return -1;
    //         }
    //         int top = head.data;
    //         return top;
    //     }
    // }

    public static void pushAtBottom(Stack<Integer> s, int data) {   //O(n)
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static String reverseString(String str) {    //O(n)
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder res = new StringBuilder("");
        while (!s.isEmpty()) {
            res.append(s.pop());
        }
        return res.toString();
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void main(String[] args) {
        //Stack s = new Stack();
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        // pushAtBottom(s, 4);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
        System.out.println();
        // System.out.println(reverseString("HelloWorld"));
        s.push(1);
        s.push(2);
        s.push(3);
        reverseStack(s);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
