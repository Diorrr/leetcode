package problems.leetcode.easy;

/**
 * Problem: <a href="https://leetcode.com/problems/number-of-1-bits">
 * number-of-1-bits</a>
 * Time Complexity: O(1)
 * Space Complexity：O(1)
 */
class Solution191 {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                res++;
            }
            n /= 2;
        }
        return res;
    }

    public int hammingWeight2(int n) {
        int res = 0;
        for (int j = 0; j < 32; j++) {
            if ((n & (1L << j)) != 0) {
                res++;
            }
        }
        return res;
    }
}
