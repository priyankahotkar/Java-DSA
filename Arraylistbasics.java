import java.util.ArrayList;

public class Arraylistbasics {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();
        list.add(1);    //O(1)
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);

        //Get operation
        int element = list.get(2);  //O(1)
        System.out.println(element);

        //Delete
        list.remove(2);     //O(n)
        System.out.println(list);

        //set element at index
        list.set(2, 10);    //O(n)
        System.out.println(list);

        //contains element
        System.out.println(list.contains(1));
        System.out.println(list.contains(11));

        //add at index
        list.add(1, 8);     //O(n)
        System.out.println(list);
        System.out.println(list.size());

        //print the arraylist
        for (Integer i : list) {
            System.out.print(i+" ");
        }
        System.out.println();

        //reverse an arraylist
        for (int i = list.size()-1; i >= 0; i--) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        
        //maximum in an arraylist
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            // if (list.get(i)>max) {
            //     max = list.get(i);
            // }
            max = Math.max(max, list.get(i));
        }
        System.out.println(max);
    }
}
