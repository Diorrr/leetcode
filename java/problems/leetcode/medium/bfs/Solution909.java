package problems.leetcode.medium.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/snakes-and-ladders">
 * snakes-and-ladders</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution909 {
    public int snakesAndLadders(int[][] board) {
        int value = 1;
        int target = board.length * board.length;
        Map<Integer, int[]> numToCoord = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < board.length; j++) {
                    numToCoord.put(value++, new int[]{board.length - i - 1, j});
                }
            } else {
                for (int j = board.length - 1; j >= 0; j--) {
                    numToCoord.put(value++, new int[]{board.length - i - 1, j});
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        boolean[] visited = new boolean[target + 1];
        visited[1] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currNum = curr[0];
            int currStep = curr[1];

            if (currNum == target) {
                return currStep;
            }

            for (int i = 1; i <= 6; i++) {
                int nextNum = currNum + i;
                if (nextNum <= target) {
                    int[] coord = numToCoord.get(nextNum);
                    if (board[coord[0]][coord[1]] != -1) {
                        nextNum = board[coord[0]][coord[1]];
                    }
                    if (!visited[nextNum]) {
                        visited[nextNum] = true;
                        queue.offer(new int[]{nextNum, currStep + 1});
                    }
                }
            }
        }
        return  -1;
    }
}
