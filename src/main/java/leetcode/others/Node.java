package leetcode.others;

import java.util.LinkedHashMap;

/**
 * @author Melody
 * @date 2021/10/18 14:35
 */
public class Node {
    public int key, val;
    public Node next, prev;

    public Node(int key, int val) {
        this.val = val;
        this.key = key;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2, 1);
        lruCache.get(1);
    }
}

class LRUCache {
    //key->Node
    LinkedHashMap cache = new LinkedHashMap();

    private int cap;

    public LRUCache(int cap) {
        this.cap = cap;
    }

    /*将某个key提升为最近使用*/
    private void makeRecently(int key) {
        int val = (int) cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return (int) cache.get(key);
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            cache.put(key, val);
            makeRecently(key);
            return;
        } else if (cache.size() >= this.cap) {
            int oldestKey = (int) cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        cache.put(key, val);
    }
}
