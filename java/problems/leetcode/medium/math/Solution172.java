package problems.leetcode.medium.math;

/**
 * Problem: <a href="https://leetcode.com/problems/factorial-trailing-zeroes">
 * factorial-trailing-zeroes</a>
 * Time Complexity: O(N)
 * Space Complexity：O(1)
 */
class Solution172 {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }

    public int trailingZeroes2(int n) {
        int res = 0;
        int[] dp = new int[n + 1];
        for (int i = 5; i <= n; i += 5) {
            dp[i] = dp[i / 5] + 1;
            res += dp[i];
        }
        return res;
    }
}
