package problems.leetcode.hard.queue;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: <a href="https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k">
 * shortest-subarray-with-sum-at-least-k</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution862 {
    public int shortestSubarray(int[] nums, int k) {
        long[] pref = new long[nums.length + 1];
        int res = nums.length + 1;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            pref[i + 1] += pref[i] + nums[i];
        }
        for (int i = 0; i < nums.length + 1; i++) {
            while (!deque.isEmpty() && pref[i] - pref[deque.getFirst()] >= k) {
                res = Math.min(i - deque.pollFirst(), res);
            }
            while (!deque.isEmpty() && pref[i] <= pref[deque.getLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return res <= nums.length ? res : -1;
    }
}
