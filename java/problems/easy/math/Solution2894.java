package problems.easy.math;

/**
 * Problem: <a href="https://leetcode.com/problems/divisible-and-non-divisible-sums-difference">
 * divisible-and-non-divisible-sums-difference</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2894 {
    public int differenceOfSums(int n, int m) {
        return (1 + n) * n / 2 - (2 * m + m * (n / m - 1)) * (n / m);
    }
}
