package problems.leetcode.medium.dfs;

import util.TreeNode;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/path-sum-ii/
 * Time Complexity:
 * Space Complexity：
 */
class Solution113 {
    public List<List<Integer>> pathSum1(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        Set<TreeNode> used = new HashSet<>();
        dfs(root, used, new ArrayList<>(), targetSum, 0, result);

        return result;
    }

    private void dfs(TreeNode root, Set<TreeNode> used, ArrayList<Integer> path, int targetSum, int sum, List<List<Integer>> result) {
        if (root != null) {
            path.add(root.val);
            used.add(root);
            sum += root.val;
            if (root.left == null && root.right == null && sum == targetSum) {
                result.add(path);
            }
            if (!used.contains(root.left)) {
                dfs(root.left, used, new ArrayList<>(path), targetSum, sum, result);
            }
            if (!used.contains(root.right)) {
                dfs(root.right, used, new ArrayList<>(path), targetSum, sum, result);
            }
        }
    }

    // solution from discussion
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        dfs(root, path, targetSum, result);

        return result;
    }

    private void dfs(TreeNode root, Stack<Integer> path, int targetSum, List<List<Integer>> result) {
        if (Objects.nonNull(root)) {
            path.push(root.val);
            if (root.left == null && root.right == null && root.val == targetSum) {
                result.add(new ArrayList<>(path));
            }
            if (root.left != null) {
                dfs(root.left, path, targetSum - root.val, result);
            }
            if (root.right != null) {
                dfs(root.right, path, targetSum - root.val, result);
            }
            path.pop();
        }
    }
}