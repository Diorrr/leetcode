package problems.leetcode.hard.backtracking;

/**
 * Problem: <a href="https://leetcode.com/problems/n-queens-ii">
 * n-queens-ii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution52 {
    int res = 0;

    public int totalNQueens(int n) {
        backtrack(0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
        return res;
    }

    private void backtrack(int row, boolean[] columns, boolean[] diag1, boolean[] diag2) {
        if (row == columns.length) {
            res++;
            return;
        }

        for (int col = 0; col < columns.length; col++) {
            if (isValid(row, col, columns, diag1, diag2)) {
                // Place the queen
                columns[col] = true;
                diag1[row - col + columns.length - 1] = true;
                diag2[row + col] = true;

                // Recur to place the next queen
                backtrack(row + 1, columns, diag1, diag2);

                // Remove the queen
                columns[col] = false;
                diag1[row - col + columns.length - 1] = false;
                diag2[row + col] = false;
            }
        }
    }

    private boolean isValid(int i, int j, boolean[] columns, boolean[] diag1, boolean[] diag2) {
        return !columns[j] && !diag1[i - j + columns.length - 1] && !diag2[i + j];
    }
}
