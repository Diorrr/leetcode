package problems.leetcode.medium.priorityqueue;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/path-with-maximum-probability">
 * path-with-maximum-probability</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1514 {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<double[]>> adj = new HashMap<>();
        double[] dist = new double[n];
        for (int i = 0; i < edges.length; i++) {
            adj.putIfAbsent(edges[i][0], new ArrayList<>());
            adj.get(edges[i][0]).add(new double[]{succProb[i], edges[i][1]});
            adj.putIfAbsent(edges[i][1], new ArrayList<>());
            adj.get(edges[i][1]).add(new double[]{succProb[i], edges[i][0]});
        }
        PriorityQueue<double[]> queue = new PriorityQueue<>(Comparator.comparingDouble(a -> -a[0]));
        queue.add(new double[]{1, start});
        while (!queue.isEmpty()) {
            double[] cur = queue.poll();
            int from = (int) cur[1];
            double cost = cur[0];
            if (from == end) {
                return cost;
            }
            if (cost > dist[from]) {
                dist[from] = cost;
                for (double[] to : adj.getOrDefault(from, List.of())) {
                    queue.add(new double[]{cost * to[0], to[1]});
                }
            }
        }
        return 0;
    }
}
