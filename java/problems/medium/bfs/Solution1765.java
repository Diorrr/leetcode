package problems.medium.bfs;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/map-of-highest-peak">
 * map-of-highest-peak</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1765 {
    public int[][] highestPeak(int[][] isWater) {
        Queue<int[]> queue = new LinkedList<>();
        int val = 0;
        boolean[][] visited = new boolean[isWater.length][isWater[0].length];
        int[][] res = new int[isWater.length][isWater[0].length];
        int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Queue<int[]> newQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                int[] pos = queue.poll();
                res[pos[0]][pos[1]] = val;
                for (int[] dir : dirs) {
                    int newX = pos[0] + dir[0];
                    int newY = pos[1] + dir[1];
                    if (newX >= 0 && newX < isWater.length && newY >= 0 && newY < isWater[0].length) {
                        if (!visited[newX][newY]) {
                            newQueue.add(new int[]{newX, newY});
                            visited[newX][newY] = true;
                        }
                    }
                }
            }
            val++;
            queue.addAll(newQueue);
        }
        return res;
    }
}
