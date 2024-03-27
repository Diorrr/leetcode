package problems.medium.dp;


/**
 * Problem: <a href="https://leetcode.com/problems/number-of-dice-rolls-with-target-sum">
 * number-of-dice-rolls-with-target-sum</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1155 {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        int mod = (int) 1e9 + 7;
        for (int i = 1; i <= Math.min(k, target); i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                for (int l = 1; l <= Math.min(k, j); l++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - l]) % mod;
                }
            }
        }

        return dp[n][target];
    }
}
