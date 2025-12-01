package problems.leetcode.easy.binsearch;


import util.TreeNode;

/**
 * Problem: <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree">
 * convert-sorted-array-to-binary-search-tree</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (right < left) {
            return null;
        }

        int mid = (left + right + 1) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums, left, mid - 1);
        node.right = build(nums, mid + 1, right);

        return node;
    }
}
