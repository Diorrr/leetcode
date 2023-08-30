package problems.easy;

import java.util.Objects;

/**
 * Problem: https://leetcode.com/problems/remove-linked-list-elements/
 * Time Complexity: O(N)
 * Space Complexity：O(1)
 */
public class Solution203 {
    //Definition for singly-linked list.
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(0, head);
        ListNode prev = newHead, cur = head;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }

        return newHead.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (Objects.nonNull(head)) {
            while (head != null && head.val == val) {
                head = head.next;
            }
            ListNode cur = new ListNode(0, head);
            while (cur != null && cur.next != null) {
                if (cur.next.val == val) {
                    ListNode next = cur.next;
                    while (next != null && next.val == val) {
                        next = next.next;
                    }
                    cur.next = next;
                    cur = next;
                } else {
                    cur = cur.next;
                }
            }
        }

        return head;
    }
}
