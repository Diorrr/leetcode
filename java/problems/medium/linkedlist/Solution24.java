package problems.medium.linkedlist;

import util.ListNode;

import java.util.Objects;

/**
 * Problem: https://leetcode.com/problems/swap-nodes-in-pairs/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = head.next.next;
        newHead.next = head;
        ListNode prev = head;
        ListNode curr = head.next;
        while (Objects.nonNull(curr) && Objects.nonNull(curr.next)) {
            ListNode t = curr.next;
            curr.next = curr.next.next;
            t.next = curr;
            prev.next = t;

            prev = curr;
            curr = curr.next;
        }

        return newHead;
    }
}
