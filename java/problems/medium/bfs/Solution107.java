package problems.medium.bfs;

import util.TreeNode;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root!=null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            res.add(new ArrayList<>());
            List<TreeNode> toAdd = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                    res.get(level).add(node.val);
                    if (node.left != null) {
                        toAdd.add(node.left);
                    }
                    if (node.right != null) {
                        toAdd.add(node.right);
                    }
                }
            }
            level++;
            queue.addAll(toAdd);
        }
        Collections.reverse(res);

        return res;
    }
}
