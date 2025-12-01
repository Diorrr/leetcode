package problems.leetcode.easy;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/invert-binary-tree">
 * invert-binary-tree</a>
 * Time Complexity: O(n+m)
 * Space Complexity：
 */
class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode swap = root.left;
            root.left = root.right;
            root.right = swap;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
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
