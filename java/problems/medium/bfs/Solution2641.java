package problems.medium.bfs;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/cousins-in-binary-tree-ii">
 * cousins-in-binary-tree-ii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2641 {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            root.val = 0;
            if (root.left != null) {
                root.left.val = 0;
            }
            if (root.right != null) {
                root.right.val = 0;
            }
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> layers = new LinkedList<>();
            int sum = 0;
            for (TreeNode curr : queue) {
                sum += childSum(curr);
            }
            while (!queue.isEmpty()) {
                var curr = queue.poll();
                var childSum = childSum(curr);
                setValueAndAddQueue(curr.left, sum-childSum, layers);
                setValueAndAddQueue(curr.right, sum-childSum, layers);
            }
            queue.addAll(layers);
        }
        return root;
    }

    private void setValueAndAddQueue(TreeNode node, int value, Queue<TreeNode> layers) {
        if (node != null) {
            node.val = value;
            layers.add(node);
        }
    }

    private int childSum(TreeNode curr) {
        return (curr.left == null ? 0 : curr.left.val) + (curr.right == null ? 0 : curr.right.val);
    }
}
