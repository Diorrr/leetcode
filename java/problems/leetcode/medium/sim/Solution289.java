package problems.leetcode.medium.sim;

/**
 * Problem: <a href="https://leetcode.com/problems/game-of-life">
 * game-of-life</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution289 {
    public void gameOfLife(int[][] board) {
        int[][] res = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = count(i, j, board);
                res[i][j]=board[i][j];
                if (board[i][j] == 0) {
                    if (count == 3) {
                        res[i][j] = 1;
                    }
                } else {
                    if (count < 2 || count > 3) {
                        res[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = res[i][j];
            }
        }
    }

    private int count(int i, int j, int[][] board) {
        int count = 0;
        int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for (int[] dir : dirs) {
            int newX = i + dir[0];
            int newY = j + dir[1];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                count += board[newX][newY];
            }
        }

        return count;
    }
}
