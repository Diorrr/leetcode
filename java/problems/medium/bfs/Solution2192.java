package problems.medium.bfs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph">
 * all-ancestors-of-a-node-in-a-directed-acyclic-graph</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2192 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
        }
        for (int i = 0; i < n; i++) {
            queue.add(i);
            boolean[] used = new boolean[n];
            while (!queue.isEmpty()) {
                int node = queue.poll();
                used[node] = true;
                for (Integer to : map.getOrDefault(node, List.of())) {
                    if (!used[to]) {
                        res.get(to).add(i);
                        queue.add(to);
                    }
                }
            }
        }
        for (List<Integer> list : res) {
            list.sort(Integer::compareTo);
        }
        return res;
    }
}
