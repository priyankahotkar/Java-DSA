public class GridWays {
    public static int findWays(int current_x, int current_y, int n, int m) {
        if (current_x == n-1 && current_y == m-1 ){
            return 1;
        } else if(current_x == n || current_y == m) {
            return 0;
        }
        int w1 = findWays(current_x+1,current_y,n,m);
        int w2 = findWays(current_x, current_y+1, n, m);
        return w1+w2;
    }
    public static void main(String[] args) {
        int n = 3, m = 3;
        int ways = findWays(0, 0, n, m);
        System.out.println(ways);
    }
}
