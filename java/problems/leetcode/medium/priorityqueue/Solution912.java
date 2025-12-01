package problems.leetcode.medium.priorityqueue;


import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/sort-an-array">
 * sort-an-array</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution912 {
    public int[] sortArray(int[] nums) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = queue.poll();
        }
        return nums;
    }
}
