package problems.leetcode.medium.dfs;

import util.TreeNode;

import java.util.Stack;

/**
 * Problem: <a href="https://leetcode.com/problems/validate-binary-search-tree">
 * validate-binary-search-tree</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            root = stack.pop();
            if (pre != null && pre.val >= root.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }

        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        return check(root, null, null);
    }

    private boolean check(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }

        return check(root.left, min, root.val) && check(root.right, root.val, max);
    }
}
