package problems.leetcode.medium.math;

import util.ListNode;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: <a href="https://leetcode.com/problems/add-two-numbers-ii">
 * add-two-numbers-ii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> queue1 = new ArrayDeque<>();
        Deque<ListNode> queue2 = new ArrayDeque<>();
        while (l1 != null) {
            queue1.add(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            queue2.add(l2);
            l2 = l2.next;
        }
        ListNode prev = null;
        boolean isOverflow = false;
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            ListNode a = queue1.pollLast();
            ListNode b = queue2.pollLast();
            int sum = (a != null ? a.val : 0) + (b != null ? b.val : 0) + (isOverflow ? 1 : 0);
            if (a != null) {
                a.val = sum % 10;
                isOverflow = sum > 9;
                a.next = prev;
                prev = a;
            } else {
                b.val = sum % 10;
                isOverflow = sum > 9;
                b.next = prev;
                prev = b;
            }
        }

        return isOverflow ? new ListNode(1, prev) : prev;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while (l1 != null) {
            sb1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            sb2.append(l2.val);
            l2 = l2.next;
        }
        String sum = new BigInteger(sb1.toString()).add(new BigInteger(sb2.toString())).toString();
        ListNode res = new ListNode();
        ListNode prev = new ListNode();
        res.next = prev;

        for (char number : sum.toCharArray()) {
            ListNode curr = new ListNode();
            curr.val = number - '0';
            prev.next = curr;
            prev = curr;
        }

        return res.next.next;
    }
}
