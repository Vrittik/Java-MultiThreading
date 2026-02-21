package ConcurrentLogProcessing;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
        Concurrent hashmaps are thread safe hashmap, they put a lock at bucket level
        A bucket is the collection of all entries (keys + values) whose hashes map to the same index in the internal table.
        When a thread tries to update the value of a key, it puts a write lock
        on the bucket so that other keys can just read the value (sync might not be there
        until write completes).

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
public class ConcurrentLogProcessor {

    public class Record
    {
        LocalDateTime timestamp;
        int count;

        public Record(LocalDateTime timeStamp, int count)
        {
            this.timestamp = timeStamp;
            this.count = count;
        }
    }

    public ConcurrentHashMap<String, Record> map = new ConcurrentHashMap<>();

    public void acceptLog(String logLine){

        String[] parts = logLine.split(",");

        String user = parts[0];
        String action = parts[1];
        LocalDateTime timestamp = LocalDateTime.parse(parts[2]);

        String key = user + action;
        map.compute(key, (k, v) -> {
            if(v != null && v.timestamp.equals(timestamp))
            {
                return v;
            }
            return new Record(timestamp, v == null? 1 : v.count + 1);
        });
    }

    public Map<String, Integer> getUserEventCounts(String userId){
        HashMap<String, Integer> result = new HashMap<>();
        String keyLogin = userId + "LOGIN";
        String keyLogout = userId + "LOGOUT";

        Record loginRecord = map.get(keyLogin);
        Record logoutRecord = map.get(keyLogout);
        result.put("LOGIN", loginRecord.count);
        result.put("LOGOUT", logoutRecord.count);

        return result;
    }
}
