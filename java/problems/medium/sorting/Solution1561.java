package problems.medium.sorting;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/maximum-number-of-coins-you-can-get">
 * maximum-number-of-coins-you-can-get</a>
 * Time Complexity: O(N)
 * Space Complexity：O(1)
 */
class Solution1561 {
    public int maxCoins(int[] piles) {
        int res = 0;
        Arrays.sort(piles);
        for (int i = piles.length / 3; i < piles.length; i += 2) {
            res += piles[i];
        }

        return res;
    }
}
