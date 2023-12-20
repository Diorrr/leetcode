package problems.medium.dp;

/**
 * Problem: <a href="https://leetcode.com/problems/house-robber">
 * house-robber</a>
 * Time Complexity: O(N)
 * Space Complexity： O(N)
 */
class Solution198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }

        return dp[nums.length];
    }
}
