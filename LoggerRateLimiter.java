import java.util.HashMap;

public class LoggerRateLimiter {
    class Logger {
        public HashMap<String, Integer> map;
        public Logger() {
            map = new HashMap<>();
        }
        public boolean shouldPrintMessage(int timetamp, String msg) {
            if (map.containsKey(msg)) {
                if (timetamp >= map.get(msg) + 10) {
                    map.put(msg, timetamp);
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                map.put(msg, timetamp);
                return true;
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
