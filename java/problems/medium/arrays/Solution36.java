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
