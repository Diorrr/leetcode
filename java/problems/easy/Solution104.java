package problems.easy;

import util.TreeNode;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Time Complexity:
 * Space Complexity：
 */
class Solution104 {
    private Integer maxDepth = 0;

    public int maxDepth(TreeNode root) {
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

        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            if (Objects.nonNull(node)){
                if (Objects.isNull(node.left) && Objects.isNull(node.right)){
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
