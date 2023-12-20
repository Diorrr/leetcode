package problems.medium.dp;


/**
 * Problem: <a href="https://leetcode.com/problems/edit-distance">
 * edit-distance</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution72 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        char[] word1Chars = word1.toCharArray();
        char[] word2Chars = word2.toCharArray();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1Chars[i - 1] == word2Chars[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                }
            }
        }

        return dp[n][m];
    }
}
