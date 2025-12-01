package problems.leetcode.easy.bfs;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/minimum-absolute-difference-in-bst">
 * minimum-absolute-difference-in-bst</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution530 {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> values = new LinkedList<>();
        int res = Integer.MAX_VALUE;
        bfs(root, values);
        values.sort(Integer::compareTo);
        for (int i = 1; i < values.size(); i++) {
            res = Math.min(values.get(i) - values.get(i - 1), res);
        }
        return res;
    }

    private void bfs(TreeNode root, List<Integer> values) {
        if (root != null) {
            values.add(root.val);
            bfs(root.left, values);
            bfs(root.right, values);
        }
    }
}
