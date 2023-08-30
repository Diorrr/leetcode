package problems.medium.dfs;


import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/network-delay-time">
 * network-delay-time</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution743 {
    int[] dist;
    Map<Integer, List<Integer>> graph = new HashMap<>();

    public int networkDelayTime(int[][] times, int n, int k) {
        dist = new int[n];
        for (int[] time : times) {
            graph.putIfAbsent(time[0] - 1, new ArrayList<>());
            graph.get(time[0] - 1).add(time[1] - 1);
            graph.get(time[0] - 1).add(time[2]);
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        dfs(k - 1, 0);

        return Arrays.stream(dist).max().getAsInt() == Integer.MAX_VALUE ? -1 : Arrays.stream(dist).max().getAsInt();
    }

    private void dfs(int node, int currDist) {
        if (currDist < dist[node]) {
            dist[node] = currDist;
            if (graph.get(node) != null && !graph.get(node).isEmpty()) {
                for (int i = 1; i < graph.get(node).size(); i += 2) {
                    dfs(graph.get(node).get(i - 1), currDist + graph.get(node).get(i));
                }
            }
        }
    }
}
