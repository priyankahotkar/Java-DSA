import java.util.ArrayList;

public class BeautifulArraylist {
    public static ArrayList<Integer> beautifulArray(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        divideConquer(1, 1, res, n);
        return res;
    }
    public static void divideConquer(int start, int increment, ArrayList<Integer> res, int n) {
        if (start + increment > n) {
            res.add(start);
            return;
        }
        divideConquer(start, 2 * increment, res, n);    //left half
        divideConquer(start + increment, 2 * increment, res, n);    //right half
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a = beautifulArray(6);
        System.out.println(a);
    }
}
