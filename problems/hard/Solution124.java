package problems.hard;

import util.TreeNode;

import java.util.Objects;

/**
 * Problem: https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution124 {
    // idea from Solution543
    private Integer maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        max(root);
        return maxSum;
    }

    private int max(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }

        int left = Math.max(0, max(root.left));
        int right = Math.max(0, max(root.right));

        maxSum = Math.max(maxSum, left + right + root.val);

        return Math.max(left, right) + root.val;
    }
}
