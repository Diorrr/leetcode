package problems.leetcode.hard.bfs;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner">
 * minimum-obstacle-removal-to-reach-corner</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2290 {
    public int minimumObstacles(int[][] grid) {
        int[][] dist = new int[grid.length][grid[0].length];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        dist[0][0] = 0;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] dir : dirs) {
                int newX = pos[0] + dir[0];
                int newY = pos[1] + dir[1];
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                    if (dist[newX][newY] > dist[pos[0]][pos[1]] + grid[newX][newY]) {
                        dist[newX][newY] = dist[pos[0]][pos[1]] + grid[newX][newY];
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }

        return dist[grid.length - 1][grid[0].length - 1];
    }
}
