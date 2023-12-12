package problems.medium.bfs;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/binary-tree-level-order-traversal">
 * binary-tree-level-order-traversal</a>
 * Time Complexity: O(N)
 * Space Complexity：
 */
class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
            queue.add(null);
        }

        List<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                res.add(level);
                level = new ArrayList<>();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                level.add(curr.val);
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }

        return res;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            List<TreeNode> toAdd = new ArrayList<>();
            List<Integer> toAddVal = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                toAddVal.add(node.val);
                if (node.left != null) {
                    toAdd.add(node.left);
                }
                if (node.right != null) {
                    toAdd.add(node.right);
                }

            }
            res.add(toAddVal);
            queue.addAll(toAdd);
        }

        return res;
    }
}
