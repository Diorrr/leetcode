package problems.medium.pointer;

import util.ListNode;

import java.util.ArrayList;
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
        if (head.next == null && n == 1) {
            return null;
        }
        ListNode prev, curr, next;
        curr = head;
        List<ListNode> list = new ArrayList<>(List.of(curr));
        while (curr.next != null) {
            curr = curr.next;
            list.add(curr);
        }
        if (list.size() - n > 0 && n - 1 > 0) {
            prev = list.get(list.size() - n - 1);
            next = list.get(list.size() - n + 1);
            prev.next = next;
        } else if (list.size() - n > 0) {
            prev = list.get(list.size() - n - 1);
            prev.next = null;
        } else if (n - 1 > 0) {
            head = head.next;
        }

        return head;
    }
}
