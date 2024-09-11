package problems.easy.math;


/**
 * Problem: <a href="https://leetcode.com/problems/minimum-bit-flips-to-convert-number">
 * minimum-bit-flips-to-convert-number</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2220 {
    public int minBitFlips(int start, int goal) {
        int res = 0;
        while (start > 0 || goal > 0) {
            res += (start % 2 == goal % 2) ? 0 : 1;
            start /= 2;
            goal /= 2;
        }

        return res;
    }
}
