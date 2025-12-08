package problems.leetcode.medium.dfs;


import problems.leetcode.util.ListNode;
import problems.leetcode.util.TreeNode;

/**
 * Problem: <a href="https://leetcode.com/problems/linked-list-in-binary-tree">
 * linked-list-in-binary-tree</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1367 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        } else if (root == null) {
            return false;
        }

        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        } else if (root == null) {
            return false;
        }
        return head.val == root.val && (dfs(head.next, root.left) || dfs(head.next, root.right));
    }
}
