package problems.medium.dp;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/minimum-cost-for-tickets">
 * minimum-cost-for-tickets</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution983 {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        dp[0] = Arrays.stream(costs).min().getAsInt();
        for (int i = 1; i < days.length; i++) {
            dp[i] = dp[i - 1] + costs[0];
            for (int j = 0; j <= i; j++) {
                int poss = i == j ? 0 : dp[i - j - 1];
                if (days[i] - days[i - j] < 30) {
                    dp[i] = Math.min(dp[i], poss + costs[2]);
                }
                if (days[i] - days[i - j] < 7) {
                    dp[i] = Math.min(dp[i], poss + costs[1]);
                }
            }
        }

        return dp[days.length - 1];
    }
}
