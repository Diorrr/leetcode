package problems.leetcode.medium.priorityqueue;

import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/kth-largest-element-in-an-array">
 * kth-largest-element-in-an-array</a>
 * Time Complexity: O(NlogN)
 * Space Complexity： O(1)
 */
class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            queue.add(num);
        }
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }

        return queue.poll();
    }

    public int findKthLargest3(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            queue.add(num);
        }

        return queue.stream().sorted().skip(nums.length - k).limit(1).findAny().get();
    }
}
