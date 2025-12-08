package problems.leetcode.medium.lca;

import problems.leetcode.util.TreeNode;

/**
 * Problem: <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree">
 * lowest-common-ancestor-of-a-binary-search-tree</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        return left != null ? (right != null ? root : left) : right;
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root, p, q);
    }

    TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }
}
