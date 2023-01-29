package problems.medium.bfs;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Problem: https://leetcode.com/problems/subtree-of-another-tree/
 * Time Complexity: O(n+m)
 * Space Complexity：
 */
class Solution572 {
    //Definition for a binary tree node.
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean res = false;

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {
                continue;
            }
            if (node.val == subRoot.val) {
                res = res || compare(node, subRoot);
            }
            queue.add(node.left);
            queue.add(node.right);
        }

        return res;
    }

    private boolean compare(TreeNode root, TreeNode subRoot) {
        if (Objects.isNull(root) && Objects.isNull(subRoot)) {
            return true;
        }
        if (Objects.isNull(root) || Objects.isNull(subRoot)) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }

        return compare(root.left, subRoot.left) && compare(root.right, subRoot.right);
    }
}
