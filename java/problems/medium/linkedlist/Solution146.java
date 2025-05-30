package problems.medium.linkedlist;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/lru-cache">
 * lru-cache</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution146 {
    public class LRUCache {
        private LinkedHashMap<Integer, Integer> map;
        private final int CAPACITY;

        public LRUCache(int capacity) {
            CAPACITY = capacity;
            map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > CAPACITY;
                }
            };
        }

        public int get(int key) {
            return map.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            map.put(key, value);
        }
    }
}
