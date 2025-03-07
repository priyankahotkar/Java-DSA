import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextGreater(int[] arr) {    //O(n)
        int[] result = new int[arr.length];
        Stack<Integer> s = new Stack<>();   //to store indices of right elements
        for (int i = arr.length-1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                result[i] = -1;
            }
            else {
                result[i] = arr[s.peek()];
            }
            s.push(i);
        }
        return result;
    }
    public static void main(String[] args) {
        int arr[] = {6, 8, 0, 1, 3};
        int[] ans = nextGreater(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }
}
