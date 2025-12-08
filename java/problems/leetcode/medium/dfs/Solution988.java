package problems.leetcode.medium.dfs;


import problems.leetcode.util.TreeNode;

/**
 * Problem: <a href="https://leetcode.com/problems/smallest-string-starting-from-leaf">
 * smallest-string-starting-from-leaf</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution988 {
    String res = null;

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return res;
    }

    private void dfs(TreeNode root, StringBuilder stringBuilder) {
        if (root != null) {
            stringBuilder.append((char) ('a' + root.val));
            if (root.left == null && root.right == null) {
                String toCompare = stringBuilder.reverse().toString();
                stringBuilder.reverse();
                if (res == null) {
                    res = toCompare;
                } else {
                    res = res.compareTo(toCompare) < 0 ? res : toCompare;
                }
            } else {
                dfs(root.left, stringBuilder);
                dfs(root.right, stringBuilder);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
