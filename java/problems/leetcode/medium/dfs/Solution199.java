package problems.leetcode.medium.dfs;

import problems.leetcode.util.TreeNode;

import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/binary-tree-right-side-view">
 * binary-tree-right-side-view</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        search(res, 0, root);

        return res;
    }

    private void search(List<Integer> res, int depth, TreeNode root) {
        if (root == null) {
            return;
        }
        if (res.size() == depth) {
            res.add(root.val);
        }

        search(res, depth + 1, root.right);
        search(res, depth + 1, root.left);
    }
}
