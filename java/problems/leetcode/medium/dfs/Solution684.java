package problems.leetcode.medium.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/redundant-connection">
 * redundant-connection</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution684 {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[1]).add(edge[0]);
            if (dfs(graph, new boolean[edges.length + 1], edge[0], -1)) {
                return edge;
            }
        }
        return new int[]{};
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int curr, int par) {
        if (visited[curr]) {
            return true;
        }
        visited[curr] = true;
        for (Integer to : graph.getOrDefault(curr, List.of())) {
            if (to != par && dfs(graph, visited, to, curr)) {
                return true;
            }
        }
        return false;
    }
}
