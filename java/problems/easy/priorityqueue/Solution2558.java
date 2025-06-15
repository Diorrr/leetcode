package problems.easy.priorityqueue;


import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/take-gifts-from-the-richest-pile">
 * take-gifts-from-the-richest-pile</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2558 {
    public long pickGifts(int[] gifts, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int gift : gifts) {
            queue.add(gift);
        }
        for (int i = 0; i < k; i++) {
            queue.add((int) Math.floor(Math.sqrt(queue.poll())));
        }

        return queue.stream().mapToLong(Long::valueOf).sum();
    }
}
