package problems.leetcode.medium.hashtable;

import util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: <a href="https://leetcode.com/problems/linked-list-cycle-ii">
 * linked-list-cycle-ii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }

        return head;
    }

    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null && head.next != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }

        return null;
    }
}
