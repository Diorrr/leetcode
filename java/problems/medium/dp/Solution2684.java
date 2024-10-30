package problems.medium.dp;


/**
 * Problem: <a href="https://leetcode.com/problems/maximum-number-of-moves-in-a-grid">
 * maximum-number-of-moves-in-a-grid</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2684 {
    public int maxMoves(int[][] grid) {
        int res = 0;
        int[][] dp = new int[grid.length][grid[0].length];
        for (int j = 0; j < grid[0].length - 1; j++) {
            for (int i = 0; i < grid.length; i++) {
                if (dp[i][j] == j) {
                    if (i > 0 && grid[i][j] < grid[i - 1][j + 1]) {
                        dp[i - 1][j + 1] = Math.max(dp[i][j] + 1, dp[i - 1][j + 1]);
                        res = Math.max(dp[i - 1][j + 1], res);
                    }
                    if (grid[i][j] < grid[i][j + 1]) {
                        dp[i][j + 1] = Math.max(dp[i][j] + 1, dp[i][j + 1]);
                        res = Math.max(dp[i][j + 1], res);
                    }
                    if (i + 1 < grid.length && grid[i][j] < grid[i + 1][j + 1]) {
                        dp[i + 1][j + 1] = Math.max(dp[i][j] + 1, dp[i + 1][j + 1]);
                        res = Math.max(dp[i + 1][j + 1], res);
                    }
                }
            }
        }
        return res;
    }

    public int maxMoves2(int[][] grid) {
        int res = 0;
        int[][] dp = new int[grid.length][grid[0].length];
        for (int j = 1; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                if (i > 0 && grid[i - 1][j - 1] < grid[i][j]) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i][j]);
                }
                if (grid[i][j - 1] < grid[i][j]) {
                    dp[i][j] = Math.max(dp[i][j - 1] + 1, dp[i][j]);
                }
                if (i + 1 < grid.length && grid[i + 1][j - 1] < grid[i][j]) {
                    dp[i][j] = Math.max(dp[i + 1][j - 1] + 1, dp[i][j]);
                }
                if (dp[i][j] < j) {
                    dp[i][j] = 0;
                } else {
                    res = Math.max(dp[i][j], res);
                }
            }
        }
        return res;
    }
}
