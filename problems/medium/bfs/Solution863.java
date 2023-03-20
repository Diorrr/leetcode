package problems.medium.bfs;

import util.TreeNode;
import util.Util;

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
        Set<Integer> used = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(target.val);
        used.add(target.val);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (Integer to : graph.get(curr)) {
                if (!used.contains(to)) {
                    used.add(to);
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

    public static void main(String[] args) {
        TreeNode root = Util.createFromArray(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        new Solution863().distanceK(root, root.left, 2);
    }
}
