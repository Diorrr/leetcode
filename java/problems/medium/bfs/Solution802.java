package problems.medium.bfs;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/find-eventual-safe-states">
 * find-eventual-safe-states</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        int[] degree = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) {
                queue.add(i);
            }
            adj.add(new ArrayList<>());
            degree[i] = graph[i].length;
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j : graph[i]) {
                adj.get(j).add(i);
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res.add(curr);
            for (Integer next : adj.get(curr)) {
                degree[next]--;
                if (degree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
