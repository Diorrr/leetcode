package problems.leetcode.easy;

import problems.leetcode.util.TreeNode;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Time Complexity:
 * Space Complexity：
 */
class Solution111 {
    private Integer minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        bfs(root);

        return minDepth == Integer.MAX_VALUE ? 0 : minDepth;
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
            if (Objects.nonNull(node)) {
                if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
                    minDepth = Math.min(minDepth, dist.get(node));
                }
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

    // solution from comments
    public int minDepth1(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}
