import java.util.Arrays;

public class DisjointSets {
    static int n = 7;
    static int par[] = new int[n];  //to store leader of a group or set
    static int rank[] = new int[n]; //to store rank i.e height of vertex

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
        Arrays.fill(rank, 0);
    }

    public static int find(int x) { //O(4k)
        if (x == par[x]) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {    //Agr koi 2 elements same set mei hai aur unka union krte hai toh cycle ki condition aati hai (par[a] == par[b])
        int parA = find(a);                     //O(4k)
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        }
        else if(rank[parA] < rank[parB]) {
            par[parA] = parB;
        }
        else {
            par[parB] = parA;
        }
    }
    public static void main(String[] args) {
        init();
        System.out.println(find(3));
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1, 5);
    }
}