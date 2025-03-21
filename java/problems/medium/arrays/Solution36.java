package problems.medium.arrays;


import java.util.HashSet;
import java.util.Set;

/**
 * Problem: <a href="https://leetcode.com/problems/valid-sudoku">
 * valid-sudoku</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            boolean[] row = new boolean[9];
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    if (row[board[i][j] - '1']) {
                        return false;
                    }
                    row[board[i][j] - '1'] = true;
                }
            }
        }

        for (int j = 0; j < board.length; j++) {
            boolean[] column = new boolean[9];
            for (int i = 0; i < board[j].length; i++) {
                if (board[i][j] != '.') {
                    if (column[board[i][j] - '1']) {
                        return false;
                    }
                    column[board[i][j] - '1'] = true;
                }
            }
        }

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[i].length; j += 3) {
                boolean[] box = new boolean[9];
                for (int k = 0; k < 9; k++) {
                    if (board[i + k / 3][j + k % 3] != '.') {
                        if (box[board[i + k / 3][j + k % 3] - '1']) {
                            return false;
                        }
                        box[board[i + k / 3][j + k % 3] - '1'] = true;
                    }
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        Set<Character>[] rows = new Set[10];
        Set<Character>[] column = new Set[10];
        Set<Character>[] box = new Set[10];
        for (int i = 0; i < board.length; i++) {
            rows[i] = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.' && rows[i].contains(board[i][j])) {
                    return false;
                }
                rows[i].add(board[i][j]);
            }
        }

        for (int i = 0; i < board.length; i++) {
            column[i] = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] != '.' && column[i].contains(board[j][i])) {
                    return false;
                }
                column[i].add(board[j][i]);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int index = (i / 3) * 3 + j / 3;
                if (box[index] == null) {
                    box[index] = new HashSet<>();
                }
                if (board[i][j] != '.' && box[index].contains(board[i][j])) {
                    return false;
                }
                box[index].add(board[i][j]);
            }
        }

        return true;
    }
}
