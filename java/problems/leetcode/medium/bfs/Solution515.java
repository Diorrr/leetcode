package problems.leetcode.medium.bfs;


import problems.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/find-largest-value-in-each-tree-row">
 * find-largest-value-in-each-tree-row</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int rowMax = Integer.MIN_VALUE;
        if (root != null) {
            queue.add(root);
        }
        int count = queue.size();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            rowMax = Math.max(rowMax, node.val);
            count--;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (count == 0) {
                res.add(rowMax);
                rowMax = Integer.MIN_VALUE;
                count = queue.size();
            }
        }
        return res;
    }
}
