package problems.leetcode.medium.dfs;


import util.TreeNode;

/**
 * Problem: <a href="https://leetcode.com/problems/add-one-row-to-tree">
 * add-one-row-to-tree</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }

        return dfs(root, val, depth - 1);
    }

    private TreeNode dfs(TreeNode root, int val, int depth) {
        if (root != null) {
            if (depth == 1) {
                root.left = new TreeNode(val, root.left, null);
                root.right = new TreeNode(val, null, root.right);
            } else {
                dfs(root.left, val, depth - 1);
                dfs(root.right, val, depth - 1);
            }
        }
        return root;
    }
}
