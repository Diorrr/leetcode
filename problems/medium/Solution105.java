package problems.medium;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Time Complexity:
 * Space Complexity：
 */
class Solution105 {
    Map<Integer, Integer> inMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = build(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1);
        root.right = build(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd);

        return root;
    }
}
