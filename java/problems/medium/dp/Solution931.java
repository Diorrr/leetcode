package problems.medium.dp;

import java.util.Arrays;

/**
 * Problem: https://leetcode.com/problems/minimum-falling-path-sum/
 * Time Complexity:
 * Space Complexity：
 */
class Solution931 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int n1 = j > 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int n2 = dp[i - 1][j];
                int n3 = j + 1 < n ? dp[i - 1][j + 1] : Integer.MAX_VALUE;
                dp[i][j] = matrix[i][j] + Math.min(n1, Math.min(n2, n3));
            }
        }

        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }
}
