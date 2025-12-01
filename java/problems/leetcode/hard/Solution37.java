package problems.leetcode.hard;

/**
 * Problem: https://leetcode.com/problems/sudoku-solver/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution37 {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        for (int i = row; i < 9; i++, col = 0) {
            for (int j = col; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char candidate = '1'; candidate <= '9'; candidate++) {
                        if (isValid(board, i, j, candidate)) {
                            board[i][j] = candidate;
                            if (solve(board, row, col + 1)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char candidate) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == candidate || board[i][col] == candidate || board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == candidate) {
                return false;
            }
        }
        return true;
    }
}
