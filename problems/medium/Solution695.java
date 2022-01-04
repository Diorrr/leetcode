package problems.medium;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Problem: https://leetcode.com/problems/max-area-of-island/
 * Time Complexity:
 * Space Complexity：
 */
class Solution695 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    AtomicInteger len = new AtomicInteger(0);
                    dfs(len, i, j, visited, grid);
                    res = Math.max(res, len.get());
                }
            }
        }

        return res;
    }

    private void dfs(AtomicInteger len, int x, int y, int[][] visited, int[][] grid) {
        if (visited[x][y] == 0) {
            len.incrementAndGet();
            visited[x][y] = len.get();
            if (x > 0 && grid[x - 1][y] == 1) {
                dfs(len, x - 1, y, visited, grid);
            }
            if (y > 0 && grid[x][y - 1] == 1) {
                dfs(len, x, y - 1, visited, grid);
            }
            if (x + 1 < grid.length && grid[x + 1][y] == 1) {
                dfs(len, x + 1, y, visited, grid);
            }
            if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
                dfs(len, x, y + 1, visited, grid);
            }
        }
    }
}
