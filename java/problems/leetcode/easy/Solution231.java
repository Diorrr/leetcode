package problems.leetcode.easy;

/**
 * Problem: <a href="https://leetcode.com/problems/power-of-two">
 * power-of-two</a>
 * Time Complexity: O(log(N))
 * Space Complexity： O(1)
 */
class Solution231 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0 || n < 0) {
            return false;
        }
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isPowerOfTwo1(int n) {
        if (n == 0 || n < 0) {
            return false;
        }
        return Math.pow(2, (int) (Math.log(n) / Math.log(2))) == n;
    }

    public boolean isPowerOfTwo2(int n) {
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
