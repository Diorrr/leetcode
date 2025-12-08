package problems.leetcode.medium.dfs;


import problems.leetcode.util.TreeNode;

import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree">
 * kth-largest-sum-in-a-binary-tree</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2583 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> levels = dfs(root, new ArrayList<>(), 0);
        Collections.sort(levels);
        return levels.size() < k ? -1 : levels.get(levels.size() - k);
    }

    private List<Long> dfs(TreeNode root, ArrayList<Long> levels, int level) {
        if (root != null) {
            if (levels.size() <= level) {
                levels.add(0L);
            }
            levels.set(level, levels.get(level) + root.val);
            dfs(root.left, levels, level + 1);
            dfs(root.right, levels, level + 1);
        }
        return levels;
    }

    public long kthLargestLevelSum2(TreeNode root, int k) {
        List<Long> levels = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            long level = 0;
            Queue<TreeNode> toAdd = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                level += curr.val;
                if (curr.left != null) {
                    toAdd.add(curr.left);
                }
                if (curr.right != null) {
                    toAdd.add(curr.right);
                }
            }
            levels.add(level);
            queue.addAll(toAdd);
        }
        Collections.sort(levels);
        return levels.size() < k ? -1 : levels.get(levels.size() - k);
    }
}
