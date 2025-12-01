package problems.leetcode.medium.bfs;

import util.TreeNode;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            List<TreeNode> toAdd = new ArrayList<>();
            List<Integer> level = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if (curr.left != null) {
                    toAdd.add(curr.left);
                }
                if (curr.right != null) {
                    toAdd.add(curr.right);
                }
            }
            queue.addAll(toAdd);
            res.add(level);
        }

        for (int i = 0; i < res.size(); i++) {
            if (i % 2 == 1) {
                Collections.reverse(res.get(i));
            }
        }

        return res;
    }
}
