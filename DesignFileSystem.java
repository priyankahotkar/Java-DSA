import java.util.HashMap;

public class DesignFileSystem {
    class FileSystem {
        public HashMap<String, Integer> map;
        public FileSystem() {
            map = new HashMap<>();
            map.put("", 0);
        }
        public boolean create(String path, int value) {
            if (map.containsKey(path)) {
                return false;
            }
            int lastSlash = path.lastIndexOf("/");
            if (!map.containsKey(path.substring(0, lastSlash))) {
                return false;
            }
            map.put(path, value);
            return true;
        }
        public int get(String path) {
            return map.getOrDefault(path, -1);
        }
    }
}
