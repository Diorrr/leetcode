package problems.leetcode.easy.dfs;

import problems.leetcode.util.TreeNode;

/**
 * Problem: <a href="https://leetcode.com/problems/">
 * diameter-of-binary-tree</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution543 {
    private Integer maxDepth = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        max(root);
        return maxDepth;
    }

    private int max(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = max(node.left);
        int right = max(node.right);

        maxDepth = Math.max(maxDepth, left + right);

        return Math.max(left, right) + 1;
    }
}
