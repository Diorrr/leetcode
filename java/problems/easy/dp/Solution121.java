package problems.easy.dp;

/**
 * Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Time Complexity: O(N)
 * Space Complexity： O(1)
 */
class Solution121 {
    public int maxProfit(int[] prices) {
        int min = prices[0], max = prices[0];
        int res = 0;
        boolean isMinSet = false;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                if (min > prices[i - 1]) {
                    max = prices[i];
                }
                min = Math.min(min, prices[i - 1]);
                isMinSet = true;
            }
            if (isMinSet) {
                max = Math.max(max, prices[i]);
                res = Math.max(res, max - min);
            }
        }

        return res;
    }

    // Kadane's Algorithm
    public int maxProfit2(int[] prices) {
        int maxCur = 0, maxCurGlob = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
            maxCurGlob = Math.max(maxCurGlob, maxCur);
        }
        return maxCurGlob;
    }
}
