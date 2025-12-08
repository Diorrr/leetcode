package problems.leetcode.easy.dfs;

import problems.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/binary-tree-preorder-traversal">
 * binary-tree-preorder-traversal</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution144 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            res.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return res;
    }
}
