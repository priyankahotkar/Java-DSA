import java.util.HashMap;

public class FindItineryFromTickets {

    public static void findJourney(HashMap<String, String> map) {   //O(n)
        HashMap<String, String> revmap = new HashMap<>();   //to -> from
        String start = "";
        for (String key : map.keySet()) {
            revmap.put(map.get(key), key);
        }
        for (String key : map.keySet()) {
            if (!revmap.containsKey(key)) {
                start = key;
                break;
            }
        }
        for (int i = 0; i < map.size(); i++) {
            System.out.print(start+" -> ");
            start = map.get(start);
        }
        System.out.print(start);
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();  //from -> to
        map.put("Chennai", "Bengaluru");
        map.put("Mumbai", "Delhi");
        map.put("Goa", "Chennai");
        map.put("Delhi", "Goa");
        findJourney(map);
    }
}
