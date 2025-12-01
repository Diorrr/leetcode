package problems.leetcode.medium.arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown">
 * best-time-to-buy-and-sell-stock-with-cooldown</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution309 {
    public int maxProfit(int[] prices) {
        int sell = 0, buy = -prices[0], cooldown = 0;
        for (int price : prices) {
            int prev = sell;
            sell = buy + price;
            buy = Math.max(buy, cooldown - price);
            cooldown = Math.max(cooldown, prev);
        }

        return Math.max(sell, cooldown);
    }
}
