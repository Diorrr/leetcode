package problems.medium.bintree;

import util.TreeNode;

/**
 * Problem: <a href="https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal">
 * problem</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int lStart, int lEnd, int rStart, int rEnd) {
        if (lStart > lEnd || rStart > rEnd) {
            return null;
        }
        if (lStart == lEnd) {
            return new TreeNode(postorder[rEnd]);
        }
        TreeNode root = new TreeNode(postorder[rEnd]);
        int rootIndex = lStart;
        for (int i = lStart; i <= lEnd; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
                break;
            }
        }
        int leftSize = rootIndex - lStart; // Number of nodes in left subtree
        root.left = buildTreeHelper(inorder, postorder, lStart, rootIndex - 1, rStart, rStart + leftSize - 1);
        root.right = buildTreeHelper(inorder, postorder, rootIndex + 1, lEnd, rStart + leftSize, rEnd - 1);
        return root;
    }
}
