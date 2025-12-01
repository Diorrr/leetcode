package problems.leetcode.easy.array;


/**
 * Problem: <a href="https://leetcode.com/problems/largest-local-values-in-a-matrix">
 * largest-local-values-in-a-matrix</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2373 {
    public int[][] largestLocal(int[][] grid) {
        int[][] res = new int[grid.length - 2][grid.length - 2];
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid.length - 2; j++) {
                res[i][j] = findMax(grid, i, j);
            }
        }

        return res;
    }

    private int findMax(int[][] grid, int x, int y) {
        int max = grid[x][y];
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                max = Math.max(grid[i][j], max);
            }
        }
        return max;
    }
}
