package problems.leetcode.easy.dfs;

import util.TreeNode;

import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree">
 * maximum-depth-of-binary-tree</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth1(TreeNode root) {
        return dfs(root, 1);
    }

    private int dfs(TreeNode root, int depth) {
        if (root == null) {
            return depth - 1;
        }
        return Math.max(dfs(root.left, depth + 1), dfs(root.right, depth + 1));
    }

    private Integer maxDepth = 0;

    public int maxDepth2(TreeNode root) {
        bfs(root);

        return maxDepth;
    }

    private void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Set<TreeNode> used = new HashSet<>();
        used.add(root);
        Map<TreeNode, Integer> dist = new HashMap<>();
        dist.put(root, 1);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node != null) {
                if (node.left == null && node.right == null) {
                    maxDepth = Math.max(maxDepth, dist.get(node));
                } else {
                    if (!used.contains(node.left)) {
                        queue.add(node.left);
                        used.add(node.left);
                        dist.put(node.left, dist.get(node) + 1);
                    }
                    if (!used.contains(node.right)) {
                        queue.add(node.right);
                        used.add(node.right);
                        dist.put(node.right, dist.get(node) + 1);
                    }
                }
            }
        }
    }
}
