package problems.leetcode.medium.dp;

/**
 * Problem: <a href="https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers">
 * ways-to-express-an-integer-as-sum-of-powers</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2787 {
    public int numberOfWays(int n, int x) {
        int[] dp = new int[n + 1];
        int mod = 1000000007;
        int pow;
        dp[0] = 1;
        for (int i = 1; (pow = (int) Math.pow(i, x)) <= n; i++) {
            for (int j = n; j >= pow; j--) {
                dp[j] = (dp[j] + dp[j - pow]) % mod;
            }
        }
        return dp[n];
    }
}
