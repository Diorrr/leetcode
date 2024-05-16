package problems.medium.dfs;


/**
 * Problem: <a href="https://leetcode.com/problems/path-with-maximum-gold">
 * path-with-maximum-gold</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1219 {
    int res = 0;
    int[] dir = {0, 1, 1, 0, 0, -1, -1, 0};

    public int getMaximumGold(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                dfs(i, j, grid, new int[grid.length][grid[i].length], 0);
            }
        }

        return res;
    }

    private void dfs(int i, int j, int[][] grid, int[][] used, int currRes) {
        used[i][j] = 1;
        currRes += grid[i][j];
        res = Math.max(currRes, res);
        for (int k = 0; k < dir.length; k += 2) {
            int newX = i + dir[k];
            int newY = j + dir[k + 1];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[i].length) {
                if (used[newX][newY] == 0 && grid[newX][newY] != 0) {
                    dfs(newX, newY, grid, used, currRes);
                }
            }
        }
        used[i][j] = 0;
    }
}
