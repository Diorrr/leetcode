package problems.easy.bit;

/**
 * Problem: <a href="https://leetcode.com/problems/smallest-number-with-all-set-bits">
 * smallest-number-with-all-set-bits</a>
 * Time Complexity: O(log n)
 * Space Complexity：O(1)
 */
class Solution3370 {
    public int smallestNumber(int n) {
        int res = n;
        int bitPosition = 0;
        while (n > 0) {
            if ((n & 1) == 0) {
                res += (1 << bitPosition);
            }
            n >>= 1;
            bitPosition++;
        }
        return res;
    }

    public int smallestNumber1(int n) {
        int res = 0;
        int bitPosition = 0;
        while (n > 0) {
            n /= 2;
            res += (1 << bitPosition);
            bitPosition++;
        }
        return res;
    }
}
