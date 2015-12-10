/*
Analogous to the C++ solution at:
https://github.com/haoel/leetcode/blob/625ad10464701fc4177b9ef33c8ad052d0a7d984/algorithms/cpp/LRUCache/LRUCache.cpp
which uses linked list + hash map. But the Java stdlib provides LinkedHashMap
which already implements that for us, making this solution shorter.
*/

import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Map;

class LinkedhashMapWithCapacity<K,V> extends LinkedHashMap<K,V> {
    private int capacity;

    public LinkedhashMapWithCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return this.size() > this.capacity;
    }
}

public class LRUCache {

    private LinkedhashMapWithCapacity<Integer,Integer> map;

    public LRUCache(int capacity) {
        this.map = new LinkedhashMapWithCapacity<>(capacity);
    }

    public int get(int key) {
        Integer value = this.map.get(key);
        if (value == null) {
            value = -1;
        } else {
            this.set(key, value);
        }
        return value;
    }

    public void set(int key, int value) {
        if (this.map.containsKey(key))
            this.map.remove(key);
        this.map.put(key, value);
    }
}
