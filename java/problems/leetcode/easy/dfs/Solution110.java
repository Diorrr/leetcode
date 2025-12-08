package problems.leetcode.easy.dfs;

import problems.leetcode.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/balanced-binary-tree">
 * balanced-binary-tree</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution110 {
    public boolean isBalanced(TreeNode root) {
        return calcHeight(root) != -1;
    }

    private int calcHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = calcHeight(root.left);
        int rightHeight = calcHeight(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    Map<TreeNode, Integer> heightMap = new HashMap<>();

    public boolean isBalanced1(TreeNode root) {
        fillHeightMap(root);
        return isBalancedChild(root);
    }

    private boolean isBalancedChild(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = heightMap.getOrDefault(root.left, 0);
        int rightHeight = heightMap.getOrDefault(root.right, 0);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        } else {
            return isBalancedChild(root.left) && isBalancedChild(root.right);
        }
    }

    private int fillHeightMap(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = fillHeightMap(root.left);
        int rightHeight = fillHeightMap(root.right);
        int height = Math.max(leftHeight, rightHeight) + 1;
        heightMap.put(root, height);
        return height;
    }
}
