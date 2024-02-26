package problems.easy;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/same-tree">
 * same-tree</a>
 * Time Complexity: O(n+m)
 * Space Complexity： O(1)
 */
class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val == q.val) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            } else {
                return false;
            }
        }
        return p == null && q == null;
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while (!queue.isEmpty()) {
            TreeNode nodeP = queue.remove();
            TreeNode nodeQ = queue.remove();
            if (nodeP != null && nodeQ != null) {
                if (nodeP.val == nodeQ.val) {
                    queue.add(nodeP.left);
                    queue.add(nodeQ.left);
                    queue.add(nodeP.right);
                    queue.add(nodeQ.right);
                } else {
                    return false;
                }
            } else if (nodeP != null || nodeQ != null) {
                return false;
            }
        }

        return true;
    }
}
