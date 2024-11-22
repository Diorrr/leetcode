package problems.medium.bintree;


import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/balance-a-binary-search-tree">
 * balance-a-binary-search-tree</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1382 {
    List<TreeNode> sorted = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        fillList(root);
        return sortedArrayToBST(0, sorted.size() - 1);
    }

    private void fillList(TreeNode root) {
        if (root != null) {
            fillList(root.left);
            sorted.add(root);
            fillList(root.right);
        }
    }

    TreeNode sortedArrayToBST(int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            TreeNode node = sorted.get(mid);
            node.left = sortedArrayToBST(start, mid - 1);
            node.right = sortedArrayToBST(mid + 1, end);
            return node;
        }
        return null;
    }
}
