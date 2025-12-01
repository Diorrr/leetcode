package problems.leetcode.medium.math;


/**
 * Problem: <a href="https://leetcode.com/problems/divide-two-integers">
 * divide-two-integers</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution29 {
    public int divide(int dividend, int divisor) {
        int res = 0;
        int sign = ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) ? 1 : -1;
        boolean isMin = dividend == Integer.MIN_VALUE;
        if (divisor == 1) {
            return dividend;
        } else if (divisor == -1){
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        }
        if (isMin) {
            if (divisor == Integer.MIN_VALUE) {
                return 1;
            } else if (divisor == Integer.MAX_VALUE) {
                return -1;
            }
            dividend = Integer.MAX_VALUE;
        }
        if (divisor == Integer.MAX_VALUE) {
            if (dividend == -Integer.MAX_VALUE) {
                return -1;
            } else if (dividend == Integer.MAX_VALUE) {
                return 1;
            } else {
                return 0;
            }
        } else if (divisor == Integer.MIN_VALUE) {
            return 0;
        }
        if (dividend < 0) {
            dividend = -dividend;
        }

        if (divisor < 0) {
            divisor = -divisor;
        }

        while (dividend >= divisor) {
            dividend -= divisor;
            res++;
        }
        if (isMin && res != Integer.MAX_VALUE) {
            dividend++;
            if (dividend == divisor) {
                res++;
            }
        }

        return sign * res;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution29().divide(-1010369383, -2147483648)
        );
    }
}
