package problems.easy.bfs;


import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/symmetric-tree">
 * symmetric-tree</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        if (root != null) {
            leftQueue.add(root.left);
            rightQueue.add(root.right);
        }

        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            TreeNode left = leftQueue.poll();
            TreeNode right = rightQueue.poll();
            if (left != null && right != null) {
                if (left.val != right.val) {
                    return false;
                }
                leftQueue.add(left.left);
                leftQueue.add(left.right);
                rightQueue.add(right.right);
                rightQueue.add(right.left);
            } else if (left != null || right != null) {
                return false;
            }
        }

        return true;
    }
}
