package problems.easy;

import util.TreeNode;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/invert-binary-tree/
 * Time Complexity: O(n+m)
 * Space Complexity：
 */
class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Set<TreeNode> used = new HashSet<>();
        used.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (Objects.nonNull(node)) {
                TreeNode t = node.left;
                node.left = node.right;
                node.right = t;
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return root;
    }
}
