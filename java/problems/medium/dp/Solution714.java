package problems.medium.dp;


/**
 * Problem: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee">
 * best-time-to-buy-and-sell-stock-with-transaction-fee</a>
 * Time Complexity: O(N)
 * Space Complexity： O(N)
 */
class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }
}
