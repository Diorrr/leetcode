package problems.leetcode.easy.array;


/**
 * Problem: <a href="https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop">
 * final-prices-with-a-special-discount-in-a-shop</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1475 {
    public int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        for (int i = prices.length - 1; i >= 0; i--) {
            res[i] = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    res[i] -= prices[j];
                    break;
                }
            }
        }

        return res;
    }
}
