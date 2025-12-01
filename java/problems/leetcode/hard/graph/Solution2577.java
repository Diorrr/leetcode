package problems.leetcode.hard.graph;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid">
 * minimum-time-to-visit-a-cell-in-a-grid</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2577 {
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{grid[0][0], 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int x = curr[1];
            int y = curr[2];
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            if (x == grid.length - 1 && y == grid[0].length - 1) {
                return time;
            }
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && !visited[newX][newY]) {
                    int wait = ((grid[newX][newY] - time) % 2 == 0) ? 1 : 0;
                    pq.offer(new int[]{Math.max(grid[newX][newY] + wait, time + 1), newX, newY});
                }
            }
        }

        return -1;
    }
}
