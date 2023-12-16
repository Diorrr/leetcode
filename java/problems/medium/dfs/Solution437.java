package problems.medium.dfs;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/path-sum-iii">
 * path-sum-iii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution437 {
    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Long> preSum = new HashMap<>();
        preSum.put(0L, 1L);
        dfs(root, 0L, targetSum, preSum);
        return res;
    }

    private void dfs(TreeNode root, long currSum, int targetSum, HashMap<Long, Long> preSum) {
        if (root != null) {
            currSum += root.val;
            res += preSum.getOrDefault(currSum - targetSum, 0L);
            preSum.put(currSum, preSum.getOrDefault(currSum, 0L) + 1);

            dfs(root.left, currSum, targetSum, preSum);
            dfs(root.right, currSum, targetSum, preSum);

            preSum.put(currSum, preSum.get(currSum) - 1);
        }
    }

    public int pathSum1(TreeNode root, int targetSum) {
        dfs(root, new ArrayList<>(), targetSum);
        return res;
    }

    private void dfs(TreeNode root, ArrayList<Long> possibleSums, int targetSum) {
        if (root != null) {
            List<Long> newSums = new ArrayList<>();
            possibleSums.add(0L);
            possibleSums.forEach(t -> newSums.add(t + root.val));
            for (Long newSum : newSums) {
                if (newSum == targetSum) {
                    res++;
                }
            }

            dfs(root.left, new ArrayList<>(newSums), targetSum);
            dfs(root.right, new ArrayList<>(newSums), targetSum);
        }
    }
}
