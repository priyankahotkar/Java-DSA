import java.util.*;
public class Arraybasics {
    public static void main(String[] args) {
        // int marks[] = new int[10];
        // marks[0] = 97;
        // marks[1] = 98;
        // marks[2] = 95;
        // System.out.print(marks[0]+" "+marks[1]+" "+marks[2]);
        // int[] marks = {97,98,95};
        // for(int i = 0; i<=3;i++) {
        //     System.out.println(marks[i]);
        // }
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int size = sc.nextInt();
        int numbers[] = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter element no."+i+" ");
            numbers[i] = sc.nextInt();
        }
        System.out.print("Enter the element to be searched : ");
        int x = sc.nextInt();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]==x) {
                System.out.print("The element is at index no."+i);
                break;
            }
        }
        sc.close();
    }
}
