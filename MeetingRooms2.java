import java.util.TreeMap;

public class MeetingRooms2 {
    public static int minRooms(int [][]arr) {
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        int ans = 0, cnt = 0;
        for(int a[] : arr) {
            int start = a[0];
            int end = a[1];
            tmap.put(start, tmap.getOrDefault(start, 0)+1);
            tmap.put(end, tmap.getOrDefault(end, 0)-1);
        }
        for(int k : tmap.keySet()) {
            cnt += tmap.get(k);
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[][] = {{0,30},{5,10},{15,20}};
        System.out.println(minRooms(arr));
    }
}