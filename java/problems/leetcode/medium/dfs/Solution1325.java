package problems.leetcode.medium.dfs;


import problems.leetcode.util.TreeNode;

/**
 * Problem: <a href="https://leetcode.com/problems/delete-leaves-with-a-given-value">
 * delete-leaves-with-a-given-value</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1325 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root != null) {
            root.left = removeLeafNodes(root.left, target);
            root.right = removeLeafNodes(root.right, target);
            if (root.left == null && root.right == null && root.val == target) {
                return null;
            }
        }
        return root;
    }
}
