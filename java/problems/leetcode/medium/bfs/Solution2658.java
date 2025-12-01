package problems.leetcode.medium.bfs;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/maximum-number-of-fish-in-a-grid">
 * maximum-number-of-fish-in-a-grid</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2658 {
    public int findMaxFish(int[][] grid) {
        int res = 0;
        int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    int curr = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    curr += grid[i][j];
                    grid[i][j] = 0;
                    while (!queue.isEmpty()) {
                        int[] pos = queue.poll();
                        grid[pos[0]][pos[1]] = 0;
                        for (int[] dir : dirs) {
                            if (pos[0] + dir[0] >= 0 && pos[1] + dir[1] >= 0 && pos[0] + dir[0] < grid.length && pos[1] + dir[1] < grid[0].length) {
                                if (grid[pos[0] + dir[0]][pos[1] + dir[1]] != 0) {
                                    curr += grid[pos[0] + dir[0]][pos[1] + dir[1]];
                                    grid[pos[0] + dir[0]][pos[1] + dir[1]] = 0;
                                    queue.add(new int[]{pos[0] + dir[0], pos[1] + dir[1]});
                                }
                            }
                        }
                    }
                    res = Math.max(curr, res);
                }
            }
        }

        return res;
    }
}
