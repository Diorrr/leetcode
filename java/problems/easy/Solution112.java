package problems.easy;

import util.TreeNode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Problem: https://leetcode.com/problems/path-sum/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution112 {
    private Boolean result = Boolean.FALSE;

    public boolean hasPathSum1(TreeNode root, int targetSum) {
        Set<TreeNode> used = new HashSet<>();
        dfs(root, used, targetSum, 0);

        return result;
    }

    private void dfs(TreeNode root, Set<TreeNode> used, int targetSum, int sum) {
        if (Objects.nonNull(root)) {
            used.add(root);
            sum += root.val;
            if (Objects.isNull(root.left) && Objects.isNull(root.right) && sum == targetSum) {
                result = Boolean.TRUE;
            }
            if (!used.contains(root.left)) {
                dfs(root.left, used, targetSum, sum);
            }
            if (!used.contains(root.right)) {
                dfs(root.right, used, targetSum, sum);
            }
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
