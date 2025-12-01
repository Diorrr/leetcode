package problems.leetcode.medium.bfs;


import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/even-odd-tree">
 * even-odd-tree</a>
 * Time Complexity: O(n+m)
 * Space Complexity：
 */
class Solution1609 {
    public boolean isEvenOddTree(TreeNode root) {
        boolean isEven = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int prev = isEven ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            while (size-- > 0) {
                var node = queue.poll();
                if (isEven && (prev >= node.val || node.val % 2 == 0)) {
                    return false;
                }
                if (!isEven && (prev <= node.val || node.val % 2 == 1)) {
                    return false;
                }
                prev = node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            isEven = !isEven;
        }

        return true;
    }
}
