package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Problem: https://leetcode.com/problems/all-paths-from-source-to-target/
 * Time Complexity:
 * Space Complexity：
 */
class Solution797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);

        dfs(0, graph, res, path);

        return res;
    }

    private void dfs(int v, int[][] graph, List<List<Integer>> res, List<Integer> path) {
        if (v == graph.length - 1) {
            res.add(new ArrayList<Integer>(path));
        }

        for (int i = 0; i < graph[v].length; i++) {
            path.add(graph[v][i]);
            dfs(graph[v][i], graph, res, path);
            path.remove(path.size() - 1);
        }
    }
}
