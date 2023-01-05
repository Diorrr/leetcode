package problems.medium;

/**
 * Problem: https://leetcode.com/problems/word-search/
 * Time Complexity:
 * Space Complexity：
 */
class Solution79 {
    int[] dir = {-1, 0, 0, -1, 0, 1, 1, 0};
    Boolean res = Boolean.FALSE;

    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    used[i][j] = true;
                    dfs(board, word, 0, used, i, j);
                    used[i][j] = false;
                }
            }
        }

        return res;
    }

    private void dfs(char[][] board, String word, int index, boolean[][] used, int x, int y) {
        if (index >= word.length()) {
            return;
        }
        if (index + 1 == word.length() && board[x][y] == word.charAt(index)) {
            res = Boolean.TRUE;
        }
        if (board[x][y] == word.charAt(index)) {
            for (int k = 0; k < dir.length; k += 2) {
                int newX = x + dir[k], newY = y + dir[k + 1];
                if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                    if (!used[newX][newY]) {
                        used[newX][newY] = Boolean.TRUE;
                        dfs(board, word, index + 1, used, newX, newY);
                        used[newX][newY] = Boolean.FALSE;
                    }
                }
            }
        }
    }
}
