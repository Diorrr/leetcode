package problems.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: https://leetcode.com/problems/shortest-path-in-binary-matrix/
 * Time Complexity: O(n+m)
 * Space Complexity：
 */
class Solution1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[] dir = {-1, 0, 0, -1, 0, 1, 1, 0, -1, -1, -1, 1, 1, 1, 1, -1};
        int[][] used = new int[grid.length][grid[0].length];
        int[][] dist = new int[grid.length][grid[0].length];
        Queue<Integer> queue = new LinkedList<>();
        if (grid[0][0] == 0) {
            queue.add(0);
            queue.add(0);
        }
        used[0][0] = 1;
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            int x = queue.remove(), y = queue.remove();
            for (int k = 0; k < dir.length; k += 2) {
                int newX = x + dir[k], newY = y + dir[k + 1];
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                    if (used[newX][newY] == 0 && grid[newX][newY] == 0) {
                        used[newX][newY] = 1;
                        dist[newX][newY] = dist[x][y] + 1;
                        queue.add(newX);
                        queue.add(newY);
                    }
                }
            }
        }
        return dist[grid.length - 1][grid[0].length - 1] != 0 ? dist[grid.length - 1][grid[0].length - 1] : -1;
    }
}
