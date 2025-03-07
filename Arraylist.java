import java.util.ArrayList;
import java.util.Collections;
public class Arraylist {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();         //a datatype which stores objects so we pass class Integer not datatype int 
        // ArrayList<String> list2 = new ArrayList<String>();       //dynamic memory allocation
        // ArrayList<Boolean> list3 = new ArrayList<>();
        list.add(0);
        list.add(2);
        System.out.println(list.get(1));
        list.add(1, 5);
        //System.out.println(list.set(1,1));
        list.set(1, 3);
        list.remove(2);
        System.out.println(list.size());
        System.out.println(list);
        list.add(4);
        list.add(6);
        list.add(1);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        Collections.sort(list);
        System.out.println(list);
    }
}
