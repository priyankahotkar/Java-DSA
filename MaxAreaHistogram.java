import java.util.Stack;

public class MaxAreaHistogram {
    public static int[] nextSmallerLeft(int[] arr) {    //O(n)
        int[] result = new int[arr.length];
        Stack<Integer> s = new Stack<>();   //to store indices of left elements
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                result[i] = -1;
            }
            else {
                result[i] = s.peek();
            }
            s.push(i);
        }
        return result;
    }

    public static int[] nextSmallerRight(int[] arr) {    //O(n)
        int[] result = new int[arr.length];
        Stack<Integer> s = new Stack<>();   //to store indices of right elements
        for (int i = arr.length-1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                result[i] = arr.length;
            }
            else {
                result[i] = s.peek();
            }
            s.push(i);
        }
        return result;
    }

    public static int largestRectangle(int arr[]) { //O(n)
        int[] nsl = nextSmallerLeft(arr);
        int[] nsr = nextSmallerRight(arr);
        int maxArea = 0;
        int area = 0;
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            area = width * height;
            // nsl[i] elements are smaller than current element in left so exclude them and from nsr[i] elements are smaller than current in right .. also you need to subtract that nsr[i]th element.
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangle(arr));
    }
}
