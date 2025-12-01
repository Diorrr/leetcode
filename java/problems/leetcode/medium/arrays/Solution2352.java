package problems.leetcode.medium.arrays;


/**
 * Problem: <a href="https://leetcode.com/problems/equal-row-and-column-pairs">
 * equal-row-and-column-pairs</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2352 {
    public int equalPairs(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                boolean isEqual = checkRowAndColumn(i, j, grid);
                if (isEqual) {
                    res++;
                }
            }
        }

        return res;
    }

    private boolean checkRowAndColumn(int row, int col, int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[row][i] != grid[i][col]) {
                return false;
            }
        }

        return true;
    }

}
