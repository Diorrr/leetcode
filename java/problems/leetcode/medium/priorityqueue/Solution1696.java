package problems.leetcode.medium.priorityqueue;


import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/jump-game-vi">
 * jump-game-vi</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1696 {
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) ->  b[0] - a[0]);
        queue.add(new int[]{nums[0], 0});
        for (int i = 1; i < nums.length; i++) {
            while (!queue.isEmpty()) {
                int[] curr = queue.peek();
                if (curr[1] >= i - k) {
                    dp[i] = nums[i] + curr[0];
                    queue.add(new int[]{dp[i], i});
                    break;
                } else {
                    queue.poll();
                }
            }
        }

        return dp[dp.length - 1];
    }
}
