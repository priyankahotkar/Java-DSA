import java.util.PriorityQueue;

public class KWeakestSoldiers {
    static class Soldier implements Comparable<Soldier>{
        int soldiers;
        int idx;
        public Soldier(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }
        @Override
        public int compareTo(Soldier s) {
            if (this.soldiers == s.soldiers) {
                return this.idx - s.idx; 
            }
            return this.soldiers - s.soldiers;
        }
    }

    private static int countSoldiers(int[] row) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == 1) {
                low = mid + 1; // Move right
            } else {
                high = mid - 1; // Move left
            }
        }
        return low; // Number of soldiers
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,0,0,0},
                          {1,1,1,1},
                          {1,0,0,0},
                          {1,0,0,0}};
        int k = 2;
        PriorityQueue<Soldier> pq = new PriorityQueue<>();
        for (int i = 0; i < matrix.length; i++) {
            int noOfSoldiers = countSoldiers(matrix[i]);
            pq.add(new Soldier(noOfSoldiers, i));
        }
        while (!pq.isEmpty() && k > 0) {
            System.out.println("Row"+pq.remove().idx);
            k--;
        }
    }
}
