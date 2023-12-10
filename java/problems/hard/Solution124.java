package problems.hard;

import util.TreeNode;

import java.util.*;


/**
 * Problem: <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum">
 * binary-tree-maximum-path-sum</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution124 {
    // idea from Solution543
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        max(root);
        return maxSum;
    }

    private int max(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, max(root.left));
        int right = Math.max(0, max(root.right));

        maxSum = Math.max(maxSum, left + right + root.val);

        return Math.max(left, right) + root.val;
    }

    // from solutions
    public int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = diameter(root.left);
        int right = diameter(root.right);
        int self = left + right + root.val;
        if (self < root.val) {
            self = root.val;
        }
        int nodeVal = Math.max(left, right) + root.val;
        if (nodeVal < root.val) {
            nodeVal = root.val;
        }
        maxSum = Math.max(maxSum, Math.max(self, nodeVal));

        return nodeVal;
    }

    public int maxPathSum1(TreeNode root) {
        int res = Integer.MIN_VALUE;
        HashMap<TreeNode, Integer> maxPath = new HashMap<>();
        maxPath.put(null, 0);
        for (TreeNode node : allNodes(root)) {
            int left = Math.max(maxPath.get(node.left), 0);
            int right = Math.max(maxPath.get(node.right), 0);
            maxPath.put(node, Math.max(left, right) + node.val);
            res = Math.max(left + right + node.val, res);
        }

        return res;
    }

    Deque<TreeNode> allNodes(TreeNode root) {
        Deque<TreeNode> res = new LinkedList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode curr = stack.pop();
                res.push(curr);
                if (curr.left != null) {
                    stack.push(curr.left);
                }
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            }
        }

        return res;
    }
}
