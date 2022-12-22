package problems.easy;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Problem: https://leetcode.com/problems/same-tree/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while (!queue.isEmpty()) {
            TreeNode nodeP = queue.remove();
            TreeNode nodeQ = queue.remove();
            if (Objects.isNull(nodeP) && Objects.isNull(nodeQ)) {
                continue;
            } else if (Objects.nonNull(nodeP) && Objects.nonNull(nodeQ)) {
                if (nodeP.val == nodeQ.val) {
                    queue.add(nodeP.left);
                    queue.add(nodeQ.left);
                    queue.add(nodeP.right);
                    queue.add(nodeQ.right);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
