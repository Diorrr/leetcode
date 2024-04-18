package problems.easy.array;


/**
 * Problem: <a href="https://leetcode.com/problems/island-perimeter">
 * island-perimeter</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution463 {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res += 4 - countNeighbours(grid, i, j);
                }
            }
        }
        return res;
    }

    private int countNeighbours(int[][] grid, int i, int j) {
        int count = 0;
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            count++;
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            count++;
        }
        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
            count++;
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
            count++;
        }

        return count;
    }
}
