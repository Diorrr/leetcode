package problems.medium.bfs;

import util.TreeNode;

/**
 * Problem: <a href="https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree">
 * count-nodes-equal-to-average-of-subtree</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2265 {
    int count = 0;

    public int averageOfSubtree(TreeNode root) {
        countAverage(root);
        return count;
    }

    private int[] countAverage(TreeNode root) {
        int[] res = new int[]{0, 0};
        if (root == null) {
            return res;
        }
        int[] left = countAverage(root.left);
        int[] right = countAverage(root.right);
        res[0] = 1 + left[0] + right[0];
        res[1] = root.val + left[1] + right[1];
        if (root.val == res[1] / res[0]) {
            count++;
        }
        return res;
    }
}
