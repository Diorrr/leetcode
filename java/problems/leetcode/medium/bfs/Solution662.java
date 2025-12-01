package problems.leetcode.medium.bfs;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: https://leetcode.com/problems/maximum-width-of-binary-tree/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution662 {
    public int widthOfBinaryTree(TreeNode root) {
        int res = 1;
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<Integer> index = new LinkedList<>();
        index.add(0);

        while (!queue.isEmpty()) {
            List<TreeNode> nodeLevel = new ArrayList<>();
            List<Integer> indexLevel = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                Integer ind = index.poll();
                if (curr.left != null) {
                    nodeLevel.add(curr.left);
                    indexLevel.add(ind * 2);
                }
                if (curr.right != null) {
                    nodeLevel.add(curr.right);
                    indexLevel.add(ind * 2 + 1);
                }
            }
            queue.addAll(nodeLevel);
            index.addAll(indexLevel);
            if (indexLevel.size() > 1) {
                res = Math.max(res, indexLevel.get(indexLevel.size() - 1) - indexLevel.get(0) + 1);
            }
        }

        return res;
    }
}
