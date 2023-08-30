package problems.medium.dfs;

import util.TreeNode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/path-sum-iii/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution437 {
    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, new ArrayList<>(), BigInteger.valueOf(targetSum));
        return res;
    }

    private void dfs(TreeNode root, ArrayList<BigInteger> possibleSums, BigInteger targetSum) {
        if (root != null) {
            List<BigInteger> newSums = new ArrayList<>();
            possibleSums.forEach(t -> newSums.add(t.add(BigInteger.valueOf(root.val))));
            for (BigInteger newSum : newSums) {
                if (newSum.equals(targetSum)) {
                    res++;
                }
            }

            newSums.add(BigInteger.valueOf(root.val));
            if (targetSum.equals(BigInteger.valueOf(root.val))) {
                res++;
            }

            dfs(root.left, new ArrayList<>(newSums), targetSum);
            dfs(root.right, new ArrayList<>(newSums), targetSum);
        }
    }
}
