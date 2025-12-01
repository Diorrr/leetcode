package problems.leetcode.medium.stack;


import util.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Problem: <a href="https://leetcode.com/problems/double-a-number-represented-as-a-linked-list">
 * double-a-number-represented-as-a-linked-list</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2816 {
    public ListNode doubleIt(ListNode head) {
        if (head.val > 4) {
            head = new ListNode(0, head);
        }
        for (ListNode curr = head; curr != null; curr = curr.next) {
            curr.val = curr.val * 2 % 10;
            if (curr.next != null && curr.next.val > 4) {
                curr.val++;
            }
        }
        return head;
    }

    public ListNode doubleIt1(ListNode head) {
        Deque<ListNode> deq = new LinkedList<>();
        ListNode curr = null;
        int isOver = 0;
        while (head != null) {
            deq.add(head);
            head = head.next;
        }
        while (!deq.isEmpty()) {
            curr = deq.pollLast();
            curr.val = curr.val * 2 + isOver;
            isOver = curr.val / 10;
            curr.val = curr.val % 10;
        }
        if (isOver > 0) {
            curr = new ListNode(isOver, curr);
        }

        return curr;
    }

    public ListNode doubleIt2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = null;
        int isOver = 0;
        while (head != null) {
            stack.add(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            curr = stack.pop();
            curr.val = curr.val * 2 + isOver;
            isOver = curr.val / 10;
            curr.val = curr.val % 10;
        }
        if (isOver > 0) {
            curr = new ListNode(isOver, curr);
        }

        return curr;
    }
}
