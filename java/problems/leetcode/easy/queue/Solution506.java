package problems.leetcode.easy.queue;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/relative-ranks">
 * relative-ranks</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution506 {
    public String[] findRelativeRanks(int[] score) {
        String[] ranks = new String[score.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            queue.add(score[i]);
            map.put(score[i], i);
        }
        if (!queue.isEmpty()) {
            ranks[map.get(queue.poll())] = "Gold Medal";
        }
        if (!queue.isEmpty()) {
            ranks[map.get(queue.poll())] = "Silver Medal";
        }
        if (!queue.isEmpty()) {
            ranks[map.get(queue.poll())] = "Bronze Medal";
        }
        int position = 4;
        while (!queue.isEmpty()) {
            ranks[map.get(queue.poll())] = String.valueOf(position++);
        }
        return ranks;
    }
}
