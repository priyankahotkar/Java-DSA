import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblem {
    public static void main(String[] args) {
        Integer[] ver = {2,1,3,1,4};
        Integer[] hori = {4,1,2};
        Arrays.sort(ver, Collections.reverseOrder());
        Arrays.sort(hori, Collections.reverseOrder());
        int h = 0;
        int v = 0;
        int hp = 1;
        int vp = 1;
        int cost = 0;
        while (h<hori.length && v<ver.length) {
            if (hori[h] <= ver[v]) {
                vp++;
                cost += hp * ver[v];
                v++;
            } else {
                hp++;
                cost += vp * hori[h];
                h++;
            }
        }
        while (h<hori.length) {
            hp++;
            cost += vp * hori[h];
            h++;
        }
        while (v<ver.length) {
            vp++;
            cost += hp * ver[v];
            v++;
        }
        System.out.println("Number of cuts for minimum cost = "+(h+v));
        System.out.println("Minimum cost = "+cost);
    }
}
