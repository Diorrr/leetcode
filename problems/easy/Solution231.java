package problems.easy;

/**
 * Problem: https://leetcode.com/problems/power-of-two/
 * Time Complexity:
 * Space Complexity：
 */
class Solution231 {
    public boolean isPowerOfTwo(int n) {
        int i = 0;
        while (n >= (1L << i)) {
            if (n == (1L << i)) {
                return true;
            }
            i++;
        }

        return false;
    }
}
