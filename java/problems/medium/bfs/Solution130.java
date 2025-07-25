package problems.medium.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/surrounded-regions">
 * surrounded-region</a>
 * Time Complexity: O(m+n)
 * Space Complexity：
 */
class Solution130 {
    int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public void solve(char[][] board) {
        int[][] used = new int[board.length][board[0].length];

        //borderSearchVertical
        for (int i = 0; i < board.length; i++) {
            if (used[i][0] == 0 && board[i][0] == 'O') {
                dfs(i, 0, used, board);
            }
            if (used[i][board[i].length - 1] == 0 && board[i][board[i].length - 1] == 'O') {
                dfs(i, board[i].length - 1, used, board);
            }
        }

        //borderSearchHorizontal
        for (int i = 0; i < board[0].length; i++) {
            if (used[0][i] == 0 && board[0][i] == 'O') {
                dfs(0, i, used, board);
            }
            if (used[board.length - 1][i] == 0 && board[board.length - 1][i] == 'O') {
                dfs(board.length - 1, i, used, board);
            }
        }

        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                if (board[i][j] == 'O' && used[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int x, int y, int[][] used, char[][] board) {
        used[x][y] = 1;
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[newX].length) {
                if (used[newX][newY] == 0 && board[newX][newY] == 'O') {
                    dfs(newX, newY, used, board);
                }
            }
        }
    }

    public void solve2(char[][] board) {
        int[][] used = new int[board.length][board[0].length];

        //borderSearchVertical
        for (int i = 0; i < board.length; i++) {
            if (used[i][0] == 0 && board[i][0] == 'O') {
                bfs(i, 0, used, board);
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (used[i][board[i].length - 1] == 0 && board[i][board[i].length - 1] == 'O') {
                bfs(i, board[i].length - 1, used, board);
            }
        }
        //borderSearchHorizontal
        for (int i = 0; i < board[0].length; i++) {
            if (used[0][i] == 0 && board[0][i] == 'O') {
                bfs(0, i, used, board);
            }
        }

        for (int i = 0; i < board[board.length - 1].length; i++) {
            if (used[board.length - 1][i] == 0 && board[board.length - 1][i] == 'O') {
                bfs(board.length - 1, i, used, board);
            }
        }

        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                if (board[i][j] == 'O' && used[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void bfs(int x, int y, int[][] used, char[][] board) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        used[x][y] = 1;
        while (!queue.isEmpty()) {
            x = queue.remove();
            y = queue.remove();
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[newX].length) {
                    if (used[newX][newY] == 0 && board[newX][newY] == 'O') {
                        queue.add(newX);
                        queue.add(newY);
                        used[newX][newY] = 1;
                    }
                }
            }
        }
    }
}
