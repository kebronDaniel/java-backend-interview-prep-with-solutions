package com.interviewPrep.practice.dsa.hashmapsAndSets;


public class BasicHashmap<K,V>{

    private static final int CAPACITY = 16;
    private Entry<K,V>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public BasicHashmap() {
        this.buckets = new Entry[CAPACITY];
        this.size = 0;
    }

    private static class Entry<K,V>{
        private K key;
        private V value;
        // use this instead of a linkedList
        private Entry<K,V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int getBucketIndex(K key){
        if (key == null) return 0;
        // this returns a value between 0-15
        return Math.floorMod(key.hashCode(), CAPACITY);
    }

    private boolean keyEquals(K key, K keyTwo){
        if (key == null) return keyTwo == null;
        return key.equals(keyTwo);
    }

    public void put(K key, V value){
        int index = getBucketIndex(key);
        Entry<K,V> head = buckets[index];

        Entry<K,V> current = head;
        while (current != null){
            if (keyEquals(current.key, key)){
                // just change the value without change in size.
                current.value = value;
                return;
            }
            current = current.next;
        }

        // means we are adding a new value.
        Entry<K,V> newEntry = new Entry<>(key,value);
        // this solves collisions, because when they happen, then since head is pointing to all the nodes in that bucket,
        // the new one just attaches itself in front making the rest(head) its next.
        newEntry.next = head;
        buckets[index] = newEntry;
        size++;
    }

    public V get(K key){
        int index = getBucketIndex(key);
        var current = buckets[index];
        while (current != null){
            if (keyEquals(current.key,key)) return current.value;
            current = current.next;
        }
        return null;
    }

    public boolean containsKey(K key){
        // this is to also cover the case whereby you save null as value
        int index = getBucketIndex(key);
        var current = buckets[index];
        while (current != null){
            if (keyEquals(current.key, key)) return true;
            current = current.next;
        }
        return false;
    }

    public V remove(K key){
        int index = getBucketIndex(key);
        var current = buckets[index];

        Entry<K,V> prev = null;
        while (current != null){
            if (keyEquals(current.key, key)){
                if (prev == null){
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    public int getSize() {
        return size;
    }
}
