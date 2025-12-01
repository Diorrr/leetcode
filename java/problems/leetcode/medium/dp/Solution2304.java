package problems.leetcode.medium.dp;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/minimum-path-cost-in-a-grid">
 * minimum-path-cost-in-a-grid</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2304 {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int[][] dp = new int[grid.length][grid[0].length];
        System.arraycopy(grid[0], 0, dp[0], 0, grid[0].length);

        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j] = dp[i-1][0] + moveCost[grid[i-1][0]][j] + grid[i][j];
                for (int k = 1; k < grid[0].length; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + moveCost[grid[i-1][k]][j] + grid[i][j]);
                }
            }
        }

        return Arrays.stream(dp[grid.length - 1]).min().getAsInt();
    }
}
