package problems.medium.lca;

import util.TreeNode;

/**
 * Problem: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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
