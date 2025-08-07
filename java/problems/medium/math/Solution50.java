package problems.medium.math;


/**
 * Problem: <a href="https://leetcode.com/problems/powx-n">
 * powx-n</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution50 {
    public double myPow(double x, int n) {
        double add = 1;
        if (n < 0) {
            x = 1 / x;
            if (n == Integer.MIN_VALUE) {
                n = -Integer.MAX_VALUE;
                add = x;
            }
            n = -n;
        }

        return add * calc2(x, n);
    }

    public double calc2(double x, int n) {
        double val = 1;
        if (n > 0) {
            val = calc2(x, n / 2);
            val *= val;
        }
        if (n %2 == 1) {
            val *= x;
        }

        return val;
    }

    public double calc(double x, int n) {
        double val = 1;
        if (n == 1) {
            val = x;
        } else if (n > 0 && n % 2 == 0) {
            val = calc(x, n / 2);
            val *= val;
        } else if (n > 0) {
            val = calc(x, n / 2);
            val *= val;
            val *= x;
        }

        return val;
    }
}
