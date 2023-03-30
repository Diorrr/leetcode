package problems.hard.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/n-queens/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution51 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] base = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                base[i][j] = '.';
            }
        }

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
                    solve(base, n, row + 1, counter + 1);
                    base[row][j] = '.';
                }
            }
        }
    }

    private boolean isValid(char[][] base, int row, int col, int n) {
        for (int i = 0; i < n; i++) {
            if (base[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            if (base[row][i] == 'Q') {
                return false;
            }
        }

        for (int i = row, j = col; i < n && j < n; i++, j++) {
            if (base[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (base[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (base[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (base[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
