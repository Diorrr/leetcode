package problems.leetcode.medium.dfs;


import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/binary-tree-paths">
 * binary-tree-paths</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res, String.valueOf(root.val));

        return res;
    }

    private void dfs(TreeNode root, List<String> res, String path) {
        if (root.left == null && root.right == null) {
            res.add(path);
        } else {
            if (root.left != null) {
                dfs(root.left, res, path + "->" + root.left.val);
            }
            if (root.right != null) {
                dfs(root.right, res, path + "->" + root.right.val);
            }
        }
    }

    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<String> queuePath = new LinkedList<>();
        queue.add(root);
        queuePath.add("");

        while (!queuePath.isEmpty()) {
            TreeNode node = queue.poll();
            String path = queuePath.poll() + node.val;
            if (node.left == null && node.right == null) {
                res.add(path);
            } else {
                if (node.left != null) {
                    queue.add(node.left);
                    queuePath.add(path + "->");
                }
                if (node.right != null) {
                    queue.add(node.right);
                    queuePath.add(path + "->");
                }
            }
        }

        return res;
    }
}
