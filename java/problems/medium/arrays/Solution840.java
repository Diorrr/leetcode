package problems.medium.arrays;


/**
 * Problem: <a href="https://leetcode.com/problems/magic-squares-in-grid">
 * magic-squares-in-grid</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution840 {
    public int numMagicSquaresInside(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (checkMagicSquare(i, j, grid)) {
                    res++;
                }
            }
        }

        return res;
    }

    private boolean checkMagicSquare(int i, int j, int[][] grid) {
        int[] used = new int[16];
        int sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
        for (int k = 0; k < 3; k++) {
            int rowSum = 0;
            int colSum = 0;
            for (int l = 0; l < 3; l++) {
                rowSum += grid[i + k][j + l];
                colSum += grid[i + l][j + k];
                used[grid[i + k][j + l]]++;
            }
            if (rowSum != sum || colSum != sum) {
                return false;
            }
        }
        for (int k = 1; k <=9 ; k++) {
            if (used[k] != 1) {
                return false;
            }
        }

        return grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] == sum && grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] == sum;
    }
}
