package problems.medium.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: https://leetcode.com/problems/rotting-oranges/
 * Time Complexity: O(n+m)
 * Space Complexity：
 */
class Solution994 {
    public int orangesRotting(int[][] grid) {
        int[][] dist = new int[grid.length][grid[0].length];
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        int[] dir = {-1, 0, 0, -1, 0, 1, 1, 0};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    dist[i][j] = 0;
                    queue.add(i);
                    queue.add(j);
                } else if (grid[i][j] == 1) {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.remove(), y = queue.remove();
            for (int k = 0; k < dir.length; k += 2) {
                int newx = x + dir[k], newy = y + dir[k + 1];
                if (newx >= 0 && newx < grid.length && newy >= 0 && newy < grid[0].length) {
                    if (grid[newx][newy] == 1 && dist[newx][newy] > dist[x][y]) {
                        dist[newx][newy] = dist[x][y] + 1;
                        queue.add(newx);
                        queue.add(newy);
                    }
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (dist[i][j] == Integer.MAX_VALUE) {
                        return -1;
                    }
                    res = Math.max(res, dist[i][j]);
                }
            }
        }

        return res;
    }
}
