package problems.leetcode.medium.bfs;


import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level">
 * minimum-number-of-operations-to-sort-a-binary-tree-by-level</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2471 {
    public int minimumOperations(TreeNode root) {
        int res = 0;
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()) {
            List<TreeNode> levelToAdd = new ArrayList<>();
            List<Integer> values = new ArrayList<>();
            Map<Integer, Integer> pos = new HashMap<>();
            for (TreeNode node : level) {
                if (node.left != null) {
                    pos.put(node.left.val, values.size());
                    levelToAdd.add(node.left);
                    values.add(node.left.val);
                }
                if (node.right != null) {
                    pos.put(node.right.val, values.size());
                    levelToAdd.add(node.right);
                    values.add(node.right.val);
                }
            }
            int count = 0;
            values.sort(Integer::compareTo);
            for (int i = 0; i < levelToAdd.size(); i++) {
                if (levelToAdd.get(i).val != values.get(i)) {
                    count++;
                    levelToAdd.get(pos.get(values.get(i))).val = levelToAdd.get(i).val;
                    pos.put(levelToAdd.get(i).val, pos.get(values.get(i)));
                    levelToAdd.get(i).val = values.get(i);
                }
            }
            level = levelToAdd;
            res += count;
        }
        return res;
    }
}
