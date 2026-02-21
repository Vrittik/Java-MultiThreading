package ConcurrentLogProcessing;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
        Problem
        ----------------------------------------------------------------
        You are asked to design a Concurrent Log Processor in Java.

        Log entries come as strings in the format:

        userId,eventType,timestamp

        Example Logs
        u1,LOGIN,2026-01-01T11:15:10
        u2,LOGOUT,2026-04-12T11:16:00
        u1,LOGIN,2026-04-11T12:17:10

        Multiple threads will push logs concurrently.

        Requirements
        -----------------------------------------------------------------
        Implement a class LogProcessor with:

        public void acceptLog(String logLine);
        // Called by multiple threads

        public Map<String, Integer> getUserEventCounts(String userId);

        acceptLog must be thread-safe

        getUserEventCounts("u1") should return something like:

        {
        "LOGIN": 2,
        "LOGOUT": 1
        }

        Solution should be thread-safe and reasonably efficient
*/
public class LogProcessor {

    public ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>> map
            = new ConcurrentHashMap<>();

    public void acceptLog(String logLine){

        String[] parts = logLine.split(",");

        String userId = parts[0];
        String action = parts[1];
        // LocalDateTime timestamp = LocalDateTime.parse(parts[2]);
        // This is not required as it's not returned

        map.computeIfAbsent(userId, u -> new ConcurrentHashMap<>())
                .merge(action, 1, Integer::sum);
    }

    public Map<String, Integer> getUserEventCounts(String userId){
        return map.get(userId);
    }
}
