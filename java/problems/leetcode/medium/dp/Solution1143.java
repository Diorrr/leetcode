package problems.leetcode.medium.dp;


/**
 * Problem: <a href="https://leetcode.com/problems/longest-common-subsequence">
 * longest-common-subsequence</a>
 * Time Complexity: O(n*m)
 * Space Complexity： O(n*m)
 */
class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                dp[i + 1][j + 1] =
                        chars1[i] == chars2[j] ? dp[i][j] + 1 : Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }

        return dp[text1.length()][text2.length()];
    }
}
