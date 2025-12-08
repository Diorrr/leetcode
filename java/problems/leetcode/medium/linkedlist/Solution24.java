package problems.leetcode.medium.linkedlist;

import problems.leetcode.util.ListNode;

/**
 * Problem: <a href="https://leetcode.com/problems/swap-nodes-in-pairs">
 * swap-nodes-in-pairs</a>
 * Time Complexity: O(N)
 * Space Complexity：O(1)
 */
class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = head.next.next;
        newHead.next = head;
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null && curr.next != null) {
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
