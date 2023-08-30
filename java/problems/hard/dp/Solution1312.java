package problems.hard.dp;

/**
 * Problem: <a href="https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome">
 *     minimum-insertion-steps-to-make-a-string-palindrome</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1312 {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int size = 1; size <= n; size++) {
            for (int i = 0; i + size < n; i++) {
                int j = i + size;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
