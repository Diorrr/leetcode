package problems.easy.dfs;


import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/binary-tree-inorder-traversal">
 * problem</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        return noOrder(root, new ArrayList<>());
    }

    private List<Integer> noOrder(TreeNode root, ArrayList<Integer> objects) {
        if (root != null) {
            noOrder(root.left, objects);
            objects.add(root.val);
            noOrder(root.right, objects);
        }

        return objects;
    }
}
