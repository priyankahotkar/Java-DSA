import java.util.Scanner;

public class MakeItDivisibleBy25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume newline

        while (t-- > 0) {
            String n = sc.nextLine();
            System.out.println(minStepsToDivisibleBy25(n));
        }
    }

    static int minStepsToDivisibleBy25(String n) {
        int minSteps = Integer.MAX_VALUE;

        minSteps = Math.min(minSteps, stepsToMakeEnding(n, '0', '0'));
        minSteps = Math.min(minSteps, stepsToMakeEnding(n, '2', '5'));
        minSteps = Math.min(minSteps, stepsToMakeEnding(n, '5', '0'));
        minSteps = Math.min(minSteps, stepsToMakeEnding(n, '7', '5'));

        return minSteps;
    }

    static int stepsToMakeEnding(String n, char d2, char d1) {
        int len = n.length();
        int idx1 = -1, idx2 = -1;

        for (int i = len - 1; i >= 0; i--) {
            if (n.charAt(i) == d1) {
                idx1 = i;

                for (int j = i - 1; j >= 0; j--) {
                    if (n.charAt(j) == d2) {
                        idx2 = j;
                        // Total digits to remove = digits between idx2 and idx1 + digits after idx1
                        int steps = (idx1 - idx2 - 1) + (len - idx1 - 1);
                        return steps;
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
