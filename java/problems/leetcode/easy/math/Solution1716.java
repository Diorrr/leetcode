package problems.leetcode.easy.math;

/**
 * Problem: <a href="https://leetcode.com/problems/calculate-money-in-leetcode-bank">
 * calculate-money-in-problems.leetcode-bank</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1716 {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;
        return  (2 * 28 + 7 * (weeks - 1)) * weeks / 2+ (2 * (weeks + 1) + days - 1) * days / 2;
    }

    public int totalMoney1(int n) {
        int res = 0;
        for (int start = 1; start <= 7 && start <= n; start++) {
            int days = (n - start) / 7 + 1;
            res += (2 * start + days - 1) * days / 2;
        }
        return res;
    }
}
