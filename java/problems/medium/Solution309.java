package problems.medium;

/**
 * Problem:
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
