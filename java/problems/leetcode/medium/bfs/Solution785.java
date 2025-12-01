package problems.leetcode.medium.bfs;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/is-graph-bipartite">
 * is-graph-bipartite</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution785 {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                queue.add(i);
                color[i] = 1;
                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    int colorV = color[v];
                    for (int j = 0; j < graph[v].length; j++) {
                        if (color[graph[v][j]] == 0) {
                            color[graph[v][j]] = -colorV;
                            queue.add(graph[v][j]);
                        } else if (color[graph[v][j]] == colorV) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
