package problems.medium.dp;

/**
 * Problem: https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 * Time Complexity:
 * Space Complexity：
 */
class Solution1277 {
    public int countSquares(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    dp[i + 1][j + 1] = 1 + Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i][j]);
                    ans += dp[i + 1][j + 1];
                }
            }
        }

        return ans;
    }

    Integer res = 0;

    public int countSquares2(int[][] matrix) {
        for (int i = 1; i <= Math.min(matrix.length, matrix[0].length); i++) {
            countMatrix(matrix, i);
        }
        return res;
    }

    private void countMatrix(int[][] matrix, int length) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (checkMatrix(matrix, i, j, length)) {
                    res++;
                }
            }
        }
    }

    private boolean checkMatrix(int[][] matrix, int x, int y, int length) {
        if (x + length - 1 >= matrix.length || y + length - 1 >= matrix[0].length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (matrix[x + i][y + j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
