public class Placetiles {
    public static int placeTiles(int n, int m) {
        if (n == m) {
            return 2;
        }
        if (n < m) {
            return 1;
        }
        //vertically
        int verticalPlacements = placeTiles(n-m, m);
        //horizontally
        int horizontalPlacements = placeTiles(n-1, m);
        return verticalPlacements + horizontalPlacements ;
    }
    public static void main(String[] args) {
        System.out.println(placeTiles(4, 2));
    }
}
