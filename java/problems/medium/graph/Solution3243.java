package problems.medium.graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i">
 * shortest-distance-after-road-addition-queries-i</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3243 {
    int[] dist;

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] res = new int[queries.length];
        dist = new int[n];
        Map<Integer, List<Integer>> edges = new HashMap<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < n - 1; i++) {
            edges.putIfAbsent(i, new ArrayList<>());
            edges.get(i).add(i + 1);
        }
        dist[0] = 0;
        bfs(0, edges);
        for (int i = 0; i < queries.length; i++) {
            edges.get(queries[i][0]).add(queries[i][1]);
            res[i] = bfs(queries[i][0], edges);
        }
        return res;
    }

    private int bfs(int start, Map<Integer, List<Integer>> edges) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Integer to : edges.getOrDefault(node, List.of())) {
                if (dist[to] >= dist[node] + 1) {
                    dist[to] = dist[node] + 1;
                    queue.add(to);
                }
            }
        }
        return dist[dist.length - 1];
    }
}
