package problems.medium.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Problem:
 * Time Complexity:
 * Space Complexity：
 */
class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            queue.add(num);
        }
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }

        return queue.poll();
    }
}
