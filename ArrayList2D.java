import java.util.ArrayList;

public class ArrayList2D {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lol = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();
        // l1.add(2);
        // l1.add(4);
        // l1.add(6);
        // l1.add(4);
        // l1.add(5);
        ArrayList<Integer> l2 = new ArrayList<>();
        // l2.add(5);
        // l2.add(9);
        // l2.add(2);
        // l2.add(4);
        // l2.add(8);
        // lol.add(l1);
        // lol.add(l2);
        ArrayList<Integer> l3 = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            l1.add(i*2);
            l2.add(i*3);
            l3.add(i*4);
        }
        lol.add(l1);
        lol.add(l2);
        lol.add(l3);
        System.out.println(lol);
    }
}
