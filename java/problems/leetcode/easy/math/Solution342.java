package problems.leetcode.easy.math;

/**
 * Problem: <a href="https://leetcode.com/problems/power-of-four">
 * power-of-four</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution342 {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n - 1) % 3 == 0;
    }

    public boolean isPowerOfFour2(int n) {
        return n != 0 && Math.pow(4, (int) (Math.log(n) / Math.log(4))) == n;
    }
}
