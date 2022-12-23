package problems.easy;

import util.TreeNode;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/average-of-levels-in-binary-tree/
 * Time Complexity:
 * Space Complexity：
 */
class Solution937 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        bfs(root, res);

        return res;
    }

    void bfs(TreeNode root, List<Double> res) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Set<TreeNode> used = new HashSet<>();
        used.add(root);
        Queue<TreeNode> queueLevel = new LinkedList<>();
        double sum = 0.0;
        int num = 0;

        while (!queue.isEmpty()) {
            TreeNode x = queue.remove();
            if (Objects.nonNull(x)) {
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
