package problems.leetcode.easy.dfs;


import problems.leetcode.util.TreeNode;

/**
 * Problem: <a href="https://leetcode.com/problems/sum-of-left-leaves">
 * sum-of-left-leaves</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                res += root.left.val;
            } else {
                res += sumOfLeftLeaves(root.left);
            }
        }
        res += sumOfLeftLeaves(root.right);
        return res;
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        return sumLeft(root.left) + sumRight(root.right);
    }

    private int sumLeft(TreeNode left) {
        if (left == null) {
            return 0;
        } else if (left.left == null && left.right == null) {
            return left.val;
        }
        return sumLeft(left.left) + sumRight(left.right);
    }

    private int sumRight(TreeNode right) {
        if (right == null) {
            return 0;
        }
        return sumLeft(right.left) + sumRight(right.right);
    }
}
