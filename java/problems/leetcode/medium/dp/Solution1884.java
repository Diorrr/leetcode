package problems.leetcode.medium.dp;

/**
 * Problem: https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/
 * Time Complexity:
 * Space Complexity：
 */
class Solution1884 {
    public int twoEggDrop(int n) {
        int[] dp = new int[1000 + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            int res = n;
            for (int j = 1; j <= i; j++) {
                res = Math.min(res, Math.max(1 + j - 1, 1 + dp[i - j]));
            }
            dp[i] = res;
        }

        return dp[n];
    }
}
