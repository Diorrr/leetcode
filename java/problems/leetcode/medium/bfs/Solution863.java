package problems.leetcode.medium.bfs;

import problems.leetcode.util.TreeNode;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution863 {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (k == 0) {
            return target == null ? new ArrayList<>() : List.of(target.val);
        }
        fillGraph(root, graph);
        List<Integer> res = new ArrayList<>();
        int[] dist = new int[501];
        int[] used = new int[501];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(target.val);
        used[target.val] = 1;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (Integer to : graph.get(curr)) {
                if (used[to] == 0) {
                    used[to] = 1;
                    queue.add(to);
                    dist[to] = dist[curr] + 1;
                    if (dist[to] == k) {
                        res.add(to);
                    }
                }
            }
        }

        return res;
    }

    private void fillGraph(TreeNode root, Map<Integer, List<Integer>> graph) {
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                graph.computeIfAbsent(curr.val, k -> new ArrayList<>());
                if (curr.left != null) {
                    queue.add(curr.left);
                    graph.computeIfAbsent(curr.left.val, k -> new ArrayList<>());
                    graph.get(curr.val).add(curr.left.val);
                    graph.get(curr.left.val).add(curr.val);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                    graph.computeIfAbsent(curr.right.val, k -> new ArrayList<>());
                    graph.get(curr.val).add(curr.right.val);
                    graph.get(curr.right.val).add(curr.val);
                }
            }
        }
    }
}
