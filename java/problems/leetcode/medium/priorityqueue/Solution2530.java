package problems.leetcode.medium.priorityqueue;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/maximal-score-after-applying-k-operations">
 * maximal-score-after-applying-k-operations</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2530 {
    public long maxKelements(int[] nums, int k) {
        long res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }
        while (k > 0) {
            res += pq.peek();
            pq.add((int) Math.ceil((double) pq.poll() / 3));
            k--;
        }

        return res;
    }
}
