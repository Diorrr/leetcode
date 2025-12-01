package problems.leetcode.easy.dfs;


import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/find-if-path-exists-in-graph">
 * find-if-path-exists-in-graph</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1971 {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> edgesMap = createMapFromEdges(edges);

        return dfs(edgesMap, visited, source, destination);
    }

    private boolean dfs(Map<Integer, List<Integer>> edgesMap, boolean[] visited, int source, int destination) {
        if (source == destination) {
            return true;
        }
        visited[source] = true;
        for (Integer to : edgesMap.getOrDefault(source, List.of())) {
            if (!visited[to] && dfs(edgesMap, visited, to, destination)) {
                return true;
            }
        }
        return false;
    }

    public boolean validPath2(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> edgesMap = createMapFromEdges(edges);
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            edgesMap.getOrDefault(queue.poll(), List.of()).forEach(to -> {
                if (!visited[to]) {
                    queue.add(to);
                    visited[to] = true;
                }
            });
        }

        return visited[destination];
    }

    private Map<Integer, List<Integer>> createMapFromEdges(int[][] edges) {
        Map<Integer, List<Integer>> edgesMap = new HashMap<>();
        for (int[] edge : edges) {
            edgesMap.putIfAbsent(edge[0], new ArrayList<>());
            edgesMap.putIfAbsent(edge[1], new ArrayList<>());
            edgesMap.get(edge[0]).add(edge[1]);
            edgesMap.get(edge[1]).add(edge[0]);
        }

        return edgesMap;
    }
}
