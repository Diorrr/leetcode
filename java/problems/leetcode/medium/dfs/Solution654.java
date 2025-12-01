package problems.leetcode.medium.dfs;

import util.TreeNode;

/**
 * Problem: https://leetcode.com/problems/maximum-binary-tree/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(null, nums, 0, nums.length - 1, false);
    }

    TreeNode buildTree(TreeNode parent, int[] nums, int start, int end, boolean isLeft) {
        int maxPos = maxPos(nums, start, end);
        if (maxPos == -1) {
            return null;
        }
        TreeNode node = new TreeNode(nums[maxPos]);
        if (isLeft && parent != null) {
            parent.left = node;
        } else if (parent != null) {
            parent.right = node;
        }
        buildTree(node, nums, start, maxPos - 1, true);
        buildTree(node, nums, maxPos + 1, end, false);

        return node;
    }

    private int maxPos(int[] nums, int start, int end) {
        int maxAt = -1;
        int max = -1;
        for (int i = start; i <= end; i++) {
            if (max < nums[i]) {
                maxAt = i;
                max = nums[i];
            }
        }

        return maxAt;
    }
}
