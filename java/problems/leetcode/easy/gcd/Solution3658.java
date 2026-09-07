package problems.leetcode.easy.gcd;

/**
 * Problem: <a href="https://leetcode.com/problems/gcd-of-odd-and-even-sums">
 * gcd-of-odd-and-even-sums</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3658 {
    public int gcdOfOddEvenSums(int n) {
        return gcd(n * n, (n + 1) * n);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
