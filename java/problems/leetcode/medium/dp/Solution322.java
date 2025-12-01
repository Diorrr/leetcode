package problems.leetcode.medium.dp;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/coin-change">
 * coin-change</a>
 * Time Complexity: O(N^2)
 * Space Complexity： O(N)
 */
class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length && i - coins[j] >= 0; j++) {
                if (dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
