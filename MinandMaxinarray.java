import java.util.Scanner;

public class MinandMaxinarray {
    public static int[] findMinAndMax(int[] numbers, int si, int ei) {
        // Base case: only one element
        if (si == ei) {
            return new int[]{numbers[si], numbers[si]}; // min and max are the same
        }

        // Base case: two elements
        if (ei == si + 1) {
            if (numbers[si] < numbers[ei]) {
                return new int[]{numbers[si], numbers[ei]};
            } else {
                return new int[]{numbers[ei], numbers[si]};
            }
        }

        // Divide the array into two halves
        int mid = (si + ei) / 2;
        int[] leftResult = findMinAndMax(numbers, si, mid);
        int[] rightResult = findMinAndMax(numbers, mid + 1, ei);

        // Combine: find the min and max from both halves
        int min = Math.min(leftResult[0], rightResult[0]);
        int max = Math.max(leftResult[1], rightResult[1]);

        return new int[]{min, max};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int size = sc.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element no. " + i + ": ");
            numbers[i] = sc.nextInt();
        }

        int[] minAndMax = findMinAndMax(numbers, 0, size - 1);
        System.out.println("The minimum value is " + minAndMax[0]);
        System.out.println("The maximum value is " + minAndMax[1]);
        sc.close();
    }
}
