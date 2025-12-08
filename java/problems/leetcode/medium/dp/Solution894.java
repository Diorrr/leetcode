package problems.leetcode.medium.dp;

import problems.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/all-possible-full-binary-trees/">
 * all-possible-full-binary-trees</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution894 {
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }
        List<TreeNode>[] dp = new List[n + 1];
        dp[1] = List.of(new TreeNode());

        for (int i = 3; i <= n; i += 2) {
            dp[i] = new ArrayList<>();
            for (int j = 1; j < i - 1; j += 2) {
                for (TreeNode left : dp[j]) {
                    for (TreeNode right : dp[i - j - 1]) {
                        TreeNode node = new TreeNode();
                        node.left = left;
                        node.right = right;
                        dp[i].add(node);
                    }
                }
            }
        }

        return dp[n];
    }
}
