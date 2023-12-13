package problems.medium.dfs;


import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list">
 * flatten-binary-tree-to-linked-list</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> allNodes = new ArrayList<>();
        allNodes.add(root);
        dfs(root, allNodes);
        for (int i = 0; i < allNodes.size() - 1; i++) {
            allNodes.get(i).left = null;
            allNodes.get(i).right = allNodes.get(i + 1);
        }
    }

    private void dfs(TreeNode node, List<TreeNode> allNodes) {
        if (node.left != null) {
            allNodes.add(node.left);
            dfs(node.left, allNodes);
        }
        if (node.right != null) {
            allNodes.add(node.right);
            dfs(node.right, allNodes);
        }
    }
}
