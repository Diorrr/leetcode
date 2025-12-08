package problems.leetcode.easy.bfs;


import problems.leetcode.util.TreeNode;

/**
 * Problem: <a href="https://leetcode.com/problems/evaluate-boolean-binary-tree">
 * evaluate-boolean-binary-tree</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2331 {
    public boolean evaluateTree(TreeNode root) {
        return switch (root.val) {
            case 0 -> false;
            case 1 -> true;
            case 2 -> evaluateTree(root.left) || evaluateTree(root.right);
            case 3 -> evaluateTree(root.left) && evaluateTree(root.right);
            default -> false;
        };
    }
}
