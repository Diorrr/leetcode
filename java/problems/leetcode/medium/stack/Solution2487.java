package problems.leetcode.medium.stack;


import util.ListNode;

import java.util.Stack;

/**
 * Problem: <a href="https://leetcode.com/problems/remove-nodes-from-linked-list">
 * remove-nodes-from-linked-list</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2487 {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            while (!stack.isEmpty() && stack.peek().val < head.val) {
                stack.pop();
            }
            stack.add(head);
            head = head.next;
        }
        for (int i = 1; i < stack.size(); i++) {
            stack.get(i - 1).next = stack.get(i);
        }
        stack.peek().next = null;

        return stack.get(0);
    }
}
