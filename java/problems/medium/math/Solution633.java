package problems.medium.math;


/**
 * Problem: <a href="https://leetcode.com/problems/sum-of-square-numbers">
 * sum-of-square-numbers</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution633 {
    public boolean judgeSquareSum(int c) {
        long a = 0;
        long b = (long) Math.sqrt(c);
        while (a <= b) {
            long curr = a * a + b * b;
            if (curr < c) {
                a++;
            } else if (curr > c) {
                b--;
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean judgeSquareSum2(int c) {
        for (long a = 0; a * a <= c; a++) {
            long b = (int) Math.sqrt(c - a * a);
            if (a * a + b * b == c) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
