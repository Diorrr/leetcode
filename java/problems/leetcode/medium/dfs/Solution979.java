package problems.leetcode.medium.dfs;


import util.TreeNode;

/**
 * Problem: <a href="https://leetcode.com/problems/distribute-coins-in-binary-tree/">
 * distribute-coins-in-binary-tree/</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution979 {
    int n = 0;
    int moves = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode root) {
        if (root != null) {
            int l = dfs(root.left);
            int r = dfs(root.right);
            moves += Math.abs(l) + Math.abs(r);
            return root.val + l + r - 1;
        }
        return 0;
    }
}
