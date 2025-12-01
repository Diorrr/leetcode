package problems.leetcode.medium.math;

/**
 * Problem: <a href="https://leetcode.com/problems/smallest-integer-divisible-by-k">
 * smallest-integer-divisible-by-k</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1015 {
    public int smallestRepunitDivByK(int k) {
        long currMod = 1 % k;
        for (int i = 1; i <= k; i++) {
            if (currMod == 0) {
                return i;
            }
            currMod = (currMod * 10 + 1) % k;
        }
        return -1;
    }
}
