import java.util.HashMap;

public class 1166.design-file-system {

    class FileSystem {
        HashMap<String, Integer> map;
        public FileSystem() {
            map = new HashMap<>();
            map.put("", 0);
        }
        boolean create(String path, int value) {
            if(map.containsKey(path)) {
                return false;
            }
            int lastSlash = path.indexOf("/");
            if(!map.containsKey(path.substring(0, lastSlash))) {
                return false;
            }
            map.put(path, value);
            return true;
        }
        int get(String path) {
            return map.getOrDefault(path, -1);
        }
    }
}