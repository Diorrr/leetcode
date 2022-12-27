package problems.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: https://leetcode.com/problems/number-of-islands/
 * Time Complexity: O(n+m)
 * Space Complexity：
 */
class Solution200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        int[][] used = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && used[i][j] == 0) {
                    dfs(i, j, used, grid);
                    res++;
                }
            }
        }

        return res;
    }

    private void dfs(int i, int j, int[][] used, char[][] grid) {
        int[] dir = {-1, 0, 0, -1, 0, 1, 1, 0};
        used[i][j] = 1;
        for (int k = 0; k < dir.length; k+=2) {
            int newX = i + dir[k], newY = j + dir[k + 1];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                if (used[newX][newY] == 0 && grid[newX][newY] == '1') {
                    dfs(newX, newY, used, grid);
                }
            }
        }
    }

    private void bfs(int i, int j, int[][] used, char[][] grid) {
        int[] dir = {-1, 0, 0, -1, 0, 1, 1, 0};
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        queue.add(j);
        used[i][j] = 1;
        while (!queue.isEmpty()) {
            int x = queue.remove(), y = queue.remove();
            for (int k = 0; k < dir.length; k += 2) {
                int newX = x + dir[k], newY = y + dir[k + 1];
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                    if (used[newX][newY] == 0 && grid[newX][newY] == '1') {
                        used[newX][newY] = 1;
                        queue.add(newX);
                        queue.add(newY);
                    }
                }
            }
        }
    }
}
