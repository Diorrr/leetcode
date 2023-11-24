package problems.medium.sorting;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/maximum-number-of-coins-you-can-get">
 * maximum-number-of-coins-you-can-get</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1561 {
    public int maxCoins(int[] piles) {
        int res = 0;
        Arrays.sort(piles);
        int n = piles.length / 3;
        for (int i = n; i < piles.length; i += 2) {
            res += piles[i];
        }

        return res;
    }
}
