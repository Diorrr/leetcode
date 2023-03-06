package problems.medium.bfs;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/minimum-height-trees/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = null;
        if (n == 1) {
            res.add(0);
            return res;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] degree = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>());
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        for (int i = 0; i < degree.length; i++) {
            if (degree[i]==1){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            res = new ArrayList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int curr = queue.poll();
                res.add(curr);
                for (Integer neighbour : graph.get(curr)) {
                    degree[neighbour]--;
                    if (degree[neighbour]==1){
                        queue.add(neighbour);
                    }
                }
            }
        }

        return res;
    }
}
