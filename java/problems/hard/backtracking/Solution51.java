package problems.hard.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/n-queens">
 * n-queens</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution51 {
    List<List<String>> res = new ArrayList<>();
    boolean[] cols;
    boolean[] rows;
    boolean[] diagLeft;
    boolean[] diagTop;

    public List<List<String>> solveNQueens(int n) {
        char[][] base = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                base[i][j] = '.';
            }
        }
        cols = new boolean[n];
        rows = new boolean[n];
        diagLeft = new boolean[n];
        diagTop = new boolean[n];

        solve(base, n, 0, 0);
        return res;
    }

    private void solve(char[][] base, int n, int row, int counter) {
        if (counter == n) {
            List<String> answer = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                answer.add(new String(base[i]));
            }
            res.add(answer);
        } else {
            for (int j = 0; j < n; j++) {
                if (isValid(base, row, j, n)) {
                    base[row][j] = 'Q';
                    set(row, j, true);

                    solve(base, n, row + 1, counter + 1);

                    base[row][j] = '.';
                    set(row, j, false);
                }
            }
        }
    }

    private void set(int row, int col, boolean flag) {
        rows[row] = true;
        cols[col] = true;
        if (row >= col) {
            diagLeft[row - col] = true;
        }
        if (row <= col) {
            diagTop[col - row] = true;
        }
    }

    private boolean isValid(char[][] base, int row, int col, int n) {
        if (rows[row] || cols[col]) {
            return false;
        }
        if ((row >= col && diagLeft[row - col]) || (row <= col && diagTop[col - row])) {
            return false;
        }
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (base[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
