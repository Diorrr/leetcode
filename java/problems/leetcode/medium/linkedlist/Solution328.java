package problems.leetcode.medium.linkedlist;

import util.ListNode;

import java.util.Objects;

/**
 * Problem: https://leetcode.com/problems/odd-even-linked-list/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next) || Objects.isNull(head.next.next)) {
            return head;
        }
        ListNode newOdd = new ListNode(0, head);

        ListNode newEven = new ListNode(0, head.next);
        ListNode even = head.next;
        head.next = head.next.next;
        head = head.next;

        while (Objects.nonNull(head) && Objects.nonNull(head.next) && Objects.nonNull(head.next.next)) {
            ListNode t = head.next;
            head.next = head.next.next;
            even.next = t;

            head = head.next;
            even = even.next;
        }
        if (Objects.nonNull(head.next)) {
            even.next = head.next;
            even = even.next;
        }
        even.next = null;
        head.next = newEven.next;

        return newOdd.next;
    }
}
