package problems.leetcode.medium.backtracking;

/**
 * Problem: <a href="https://leetcode.com/problems/word-search">
 * word-search</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution79 {
    public boolean exist(char[][] board, String word) {
        char[] wordChars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (backtr(board, wordChars, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtr(char[][] board, char[] word, int index, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] == '*' || board[row][col] != word[index]) {
            return false;
        }
        if (index + 1 == word.length) {
            return true;
        }
        char t = board[row][col];
        board[row][col] = '*';
        index++;
        if (backtr(board, word, index, row + 1, col) || backtr(board, word, index, row, col + 1)
                || backtr(board, word, index, row - 1, col) || backtr(board, word, index, row, col - 1)) {
            return true;
        }
        board[row][col] = t;

        return false;
    }

    int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public boolean exist1(char[][] board, String word) {
        char[] wordChars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    boolean[][] used = new boolean[board.length][board[0].length];
                    used[i][j] = true;
                    if (backtrack(board, wordChars, 0, used, i, j)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, char[] word, int index, boolean[][] used, int x, int y) {
        if (index >= word.length) {
            return false;
        }
        if (index == word.length - 1) {
            return board[x][y] == word[index];
        }
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                if (!used[newX][newY] && board[newX][newY] == word[index + 1]) {
                    used[newX][newY] = true;
                    if (backtrack(board, word, index + 1, used, newX, newY)) {
                        return true;
                    }
                    used[newX][newY] = false;
                }
            }
        }
        return false;
    }
}
