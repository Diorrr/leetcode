package problems.leetcode.easy.dp;

/**
 * Problem: <a href="https://leetcode.com/problems/min-cost-climbing-stairs/">
 * min-cost-climbing-stairs</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }

        return Math.min(dp[cost.length - 2], dp[cost.length - 1]);
    }
}
