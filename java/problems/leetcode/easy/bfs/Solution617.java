package problems.leetcode.easy.bfs;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: https://leetcode.com/problems/merge-two-binary-trees/
 * Time Complexity: O(m+n)
 * Space Complexity：
 */
class Solution617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 != null ? root1 : root2;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root1);
        queue2.add(root2);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            TreeNode treeNode1 = queue1.remove();
            TreeNode treeNode2 = queue2.remove();

            if (treeNode1 != null && treeNode2 != null) {
                treeNode1.val += treeNode2.val;
            }

            if (treeNode1.left != null && treeNode2.left != null) {
                queue1.add(treeNode1.left);
                queue2.add(treeNode2.left);
            } else if (treeNode1.left == null) {
                treeNode1.left = treeNode2.left;
            }

            if (treeNode1.right != null && treeNode2.right != null) {
                queue1.add(treeNode1.right);
                queue2.add(treeNode2.right);
            } else if (treeNode1.right == null) {
                treeNode1.right = treeNode2.right;
            }


        }
        return root1;
    }
}
