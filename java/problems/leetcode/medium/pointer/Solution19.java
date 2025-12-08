package problems.leetcode.medium.pointer;

import problems.leetcode.util.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list">
 * remove-nth-node-from-end-of-list</a>
 * Time Complexity: O(N)
 * Space Complexity： O(1)
 */
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode cur = head;
        ListNode prev = null;
        int count;
        if (head != null) {
            count = 1;
        } else {
            return null;
        }

        while (cur.next != null) {
            count++;
            prev = cur;
            cur = cur.next;
        }
        if (count == n) {
            head = head.next;
        } else if (n == 1) {
            prev.next = null;
        } else {
            cur = head;
            for (int i = 0; i < count - n; i++) {
                prev = cur;
                cur = cur.next;
            }
            prev.next = cur.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd3(ListNode head, int n) {
        List<ListNode> list = new LinkedList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        if (list.size() == n && list.size() == 1) {
            return null;
        } else if (list.size() == n) {
            return list.get(1);
        } else if (n == 1) {
            list.get(list.size() - 2).next = null;
        } else {
            list.get(list.size() - 1 - n).next = list.get(list.size() - n + 1);
        }
        return list.get(0);
    }
}
