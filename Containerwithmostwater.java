import java.util.ArrayList;

public class Containerwithmostwater {
    public static int bruteForce(ArrayList<Integer> a) {    //O(n)
        int maxarea = Integer.MIN_VALUE;
        for (int i = 0; i < a.size(); i++) {
            for (int j = i+1; j < a.size(); j++) {
                int height = Math.min(a.get(i), a.get(j));
                int width = j-i;
                int currArea = height*width;
                maxarea = Math.max(maxarea, currArea);
            }
        }
        return maxarea;
    }

    public static int twoPointerApproach(ArrayList<Integer> height) {   //O(n)
        int start = 0;
        int end = height.size()-1;
        int max_area = Integer.MIN_VALUE;
        while(start<end) {
            int h = Math.min(height.get(start),height.get(end));
            int width = end - start;
            int area = h*width;
            max_area = Math.max(max_area,area);
            if(height.get(start) < height.get(end)) {
                start++;
            }
            else {
                end--;
            }
        }
        return max_area;
    }
    public static void main(String[] args) {
        ArrayList<Integer> heights = new ArrayList<>();
        //heights = [1,8,6,2,5,4,8,3,7]
        heights.add(1);
        heights.add(8);
        heights.add(6);
        heights.add(2);
        heights.add(5);
        heights.add(4);
        heights.add(8);
        heights.add(3);
        heights.add(7);
        int maxArea = bruteForce(heights);
        System.out.println(maxArea);
        int maxa = twoPointerApproach(heights);
        System.out.println(maxa);
    }
}
