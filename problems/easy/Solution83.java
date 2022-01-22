package problems.easy;

import java.util.Objects;

/**
 * Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Time Complexity: O(N)
 * Space Complexity： O(1)
 */
class Solution83 {

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

    public ListNode deleteDuplicates(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val != cur.next.val) {
                cur = cur.next;
            } else {
                cur.next = cur.next.next;
            }
        }

        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (Objects.isNull(head)) {
            return head;
        }
        ListNode prev = head;
        ListNode cur = head;
        cur = cur.next;

        while (cur != null) {
            if (cur.val != prev.val) {
                prev.next = cur;
                prev = cur;
            }
            if (cur.next == null && cur.val == prev.val) {
                prev.next = null;
            }
            cur = cur.next;
        }
        return head;
    }
}
