package problems.leetcode.easy.bfs;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


/**
 * Problem: <a href="https://leetcode.com/problems/average-of-levels-in-binary-tree">
 * average-of-levels-in-binary-tree</a>
 * Time Complexity: O(n+m)
 * Space Complexity：
 */
class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            double sum = 0.0;
            int num = queue.size();
            int layerNodeCount = queue.size();
            while (layerNodeCount-- > 0) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(sum / num);
        }
        return res;
    }

    void bfs2(TreeNode root, List<Double> res) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Set<TreeNode> used = new HashSet<>();
        used.add(root);
        Queue<TreeNode> queueLevel = new LinkedList<>();
        double sum = 0.0;
        int num = 0;

        while (!queue.isEmpty()) {
            TreeNode x = queue.remove();
            if (x != null) {
                sum += x.val;
                num++;
                if (!used.contains(x.left)) {
                    queueLevel.add(x.left);
                }
                if (!used.contains(x.right)) {
                    queueLevel.add(x.right);
                }
            }

            if (queue.isEmpty() && num != 0) {
                res.add(sum / num);
                sum = 0.0;
                num = 0;
                queue.addAll(queueLevel);
                queueLevel.clear();
            }
        }
    }
}
