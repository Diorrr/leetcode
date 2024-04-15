package problems.medium.dfs;


import util.TreeNode;

/**
 * Problem: <a href="https://leetcode.com/problems/sum-root-to-leaf-numbers">
 * sum-root-to-leaf-numbers</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int curr) {
        if (root == null) {
            return 0;
        } else {
            curr = 10 * curr + root.val;
        }
        if (root.left == null && root.right == null) {
            return curr;
        }

        return dfs(root.left, curr) + dfs(root.right, curr);
    }
}
