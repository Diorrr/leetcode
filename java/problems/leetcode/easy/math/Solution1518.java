package problems.leetcode.easy.math;


/**
 * Problem: <a href="https://leetcode.com/problems/water-bottles">
 * water-bottles</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = 0;
        int rest = 0;
        while (numBottles > 0) {
            res += numBottles;
            rest += numBottles;
            numBottles=rest/numExchange;
            rest%=numExchange;
        }

        return res;
    }
}
