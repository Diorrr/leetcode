package problems.medium.greedy;

/**
 * Problem: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii">
 * best-time-to-buy-and-sell-stock-ii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution122 {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res += Math.max(0, prices[i] - prices[i - 1]);
        }
        return res;
    }
}
