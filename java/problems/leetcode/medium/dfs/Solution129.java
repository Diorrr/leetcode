package problems.leetcode.medium.dfs;


import util.TreeNode;

/**
 * Problem: <a href="https://leetcode.com/problems/sum-root-to-leaf-numbers">
 * sum-root-to-leaf-numbers</a>
 * Time Complexity: O(V + E)
 * Space Complexity：
 */
class Solution129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int sum(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return sum * 10 + node.val;
        } else {
            return sum(node.left, sum * 10 + node.val) + sum(node.right, sum * 10 + node.val);
        }
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
