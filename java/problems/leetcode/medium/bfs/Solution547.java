package problems.leetcode.medium.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: https://leetcode.com/problems/number-of-provinces/
 * Time Complexity: O(n+m)
 * Space Complexity：
 */
class Solution547 {
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        int[] used = new int[isConnected.length];

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1 && used[i] == 0 && used[j] == 0) {
                    bfs(i, used, isConnected);
                    res++;
                }
            }
        }

        return res;
    }

    private void bfs(int i, int[] used, int[][] isConnected) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        used[i] = 1;
        while (!queue.isEmpty()) {
            int x = queue.remove();
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[x][j] == 1 && used[j] == 0) {
                    queue.add(j);
                    used[j] = 1;
                }
            }
        }
    }
}
