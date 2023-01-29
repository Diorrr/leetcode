package problems.medium.dp;

import java.util.Arrays;

/**
 * Problem: https://leetcode.com/problems/coin-change/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        for (int coin : coins) {
            if (coin <= amount) {
                dp[coin] = 1;
            }
        }
        for (int i = 0; i <= amount; i++) {
            if (dp[i] == 0) {
                dp[i] = Integer.MAX_VALUE;
            }
            for (int coin : coins) {
                if (i - coin > 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == 0 || dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
