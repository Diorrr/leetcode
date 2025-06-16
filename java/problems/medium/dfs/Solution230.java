package problems.medium.dfs;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * Problem: <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst">
 * kth-smallest-element-in-a-bst</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution230 {
    int res = 0;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);

        count++;
        if (count == k) {
            res = root.val;
            return;
        }

        traverse(root.right, k);
    }

    int[] values = new int[(int) (1e4 + 1)];

    public int kthSmallest1(TreeNode root, int k) {
        dfs(root);
        for (int i = 0; i < values.length; i++) {
            if (k - values[i] > 0) {
                k -= values[i];
            } else {
                return i;
            }
        }
        return 0;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        values[root.val]++;
        dfs(root.left);
        dfs(root.right);
    }

    public int kthSmallest2(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();
        dfs(root, values);
        values.sort(Integer::compareTo);
        return values.get(k - 1);
    }

    private void dfs(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }
        values.add(root.val);
        dfs(root.left, values);
        dfs(root.right, values);
    }
}
