package problems.leetcode.medium.bit;


/**
 * Problem: <a href="https://leetcode.com/problems/bitwise-and-of-numbers-range">
 * bitwise-and-of-numbers-range</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution201 {
    public int rangeBitwiseAnd(int left, int right) {
        while (right > left) {
            right &= (right - 1);
        }
        return right;
    }
}
