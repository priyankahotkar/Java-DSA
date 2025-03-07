import java.util.Scanner;

public class TrappingRainwater2 {
    public static void trappedRainwater(int height[]) {
        int leftMaxBoundary[] = new int[height.length];
        int rightMaxBoundary[] = new int[height.length];
        leftMaxBoundary[0] = height[0];
        rightMaxBoundary[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            leftMaxBoundary[i] = Math.max(leftMaxBoundary[i-1], height[i]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rightMaxBoundary[i] = Math.max(rightMaxBoundary[i+1], height[i]);
        }
        int totalVol = 0;
        for (int i = 0; i < height.length; i++) {
            int waterLevel = Math.min(leftMaxBoundary[i], rightMaxBoundary[i]);
            int water = waterLevel - height[i];
            if (water > 0) {
                totalVol += water;
            }
        }
        System.out.println(totalVol);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt(); 
        int height[] = new int[size];
        for (int i = 0; i < height.length; i++) {
            height[i] = sc.nextInt();
        }
        trappedRainwater(height);
    }
}
