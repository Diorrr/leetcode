package problems.medium.pointer;

import util.ListNode;

/**
 * Problem: <a href="https://leetcode.com/problems/add-two-numbers">
 * add-two-numbers</a>
 * Time Complexity: O(N)
 * Space Complexity：
 */
class Solution2 {

    int toAdd = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null && toAdd == 0) {
            return null;
        }

        int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + toAdd;
        toAdd = sum / 10;

        l1 = l1 == null ? null : l1.next;
        l2 = l2 == null ? null : l2.next;

        ListNode res = new ListNode(sum % 10, addTwoNumbers(l1, l2));

        return res;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0, l1);
        rec(l1, l2, 0);

        return dummy.next;
    }

    private void rec(ListNode l1, ListNode l2, int additional) {
        if (l1 == null && l2 == null) {
            return;
        }
        if (l1 != null && l1.next == null && l2 != null) {
            l1.next = l2.next;
            l2.next = null;
        }

        l1.val += additional + (l2 == null ? 0 : l2.val);
        additional = l1.val / 10;
        l1.val %= 10;

        if (l1.next == null && (l2 == null || l2.next == null) && additional == 1) {
            l1.next = new ListNode(0);
        }

        rec(l1.next, l2 == null ? l2 : l2.next, additional);
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int additional = 0;
        while (l1 != null || l2 != null || additional == 1) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += additional;
            ListNode node = new ListNode(sum % 10);
            additional = sum / 10;
            curr.next = node;
            curr = curr.next;
        }
        return dummy.next;
    }
}
