package problems.medium.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/rotting-oranges">
 * rotting-oranges</a>
 * Time Complexity:O(n+m)
 * Space Complexity：
 */
class Solution994 {
    public int orangesRotting(int[][] grid) {
        int count = 0;
        int countFresh = 0;
        Queue<Integer> queue = new LinkedList<>();
        int[] dir = {-1, 0, 0, -1, 0, 1, 1, 0};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(i);
                    queue.add(j);
                } else if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }

        if (countFresh == 0) {
            return 0;
        }

        while (!queue.isEmpty()) {
            count++;
            int size = queue.size() / 2;
            for (int i = 0; i < size; i++) {
                int x = queue.remove(), y = queue.remove();
                for (int k = 0; k < dir.length; k += 2) {
                    int newX = x + dir[k];
                    int newY = y + dir[k + 1];
                    if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        queue.add(newX);
                        queue.add(newY);
                        countFresh--;
                    }
                }
            }
        }

        return countFresh == 0 ? count - 1 : -1;
    }


    public int orangesRotting1(int[][] grid) {
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
