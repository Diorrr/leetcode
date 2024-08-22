package problems.hard.dp;


/**
 * Problem: <a href="https://leetcode.com/problems/strange-printer">
 * strange-printer</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution664 {
    public int strangePrinter(String s) {
        char[] chars = s.toCharArray();
        int[][] dp = new int[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++) {
            dp[i][i] = 1;
            if (i + 1 < chars.length) {
                dp[i][i + 1] = chars[i] == chars[i + 1] ? 1 : 2;
            }
        }

        for (int len = 2; len < chars.length; len++) {
            for (int start = 0; start + len < chars.length; start++) {
                dp[start][start + len] = len + 1;
                for (int k = 0; k < len; k++) {
                    int temp = dp[start][start + k] + dp[start + k + 1][start + len];
                    dp[start][start + len] = Math.min(chars[start + k] == chars[start + len] ? temp - 1 : temp,
                                                      dp[start][start + len]);
                }
            }
        }

        return dp[0][chars.length - 1];
    }
}
