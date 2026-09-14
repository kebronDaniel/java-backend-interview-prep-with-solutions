package com.interviewPrep.practice.dsa.stacksAndQueues;

import java.util.LinkedHashMap;
import java.util.Map;

// this is LRU that acts like a cache with limited capacity.
public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity,0.75f, true);
        if (capacity <= 0) throw new IllegalArgumentException("Invalid capacity: "+ capacity);
        this.capacity = capacity;
    }

    public Integer get(Object key) {
        return super.getOrDefault(key, -1);
    }

    @Override
    public Integer put(Integer key, Integer value) {
        return super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        // the method is internally called when you call put or putall, and it defaults to false to keep increasing
        // based on the load factor.
       return size() > capacity;
    }
}
