package problems.leetcode.easy.twopointer;

import problems.leetcode.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: <a href="https://leetcode.com/problems/linked-list-cycle">
 * linked-list-cycle</a>
 * Time Complexity: O(N)
 * Space Complexity： O(1)
 */
class Solution141 {
    public boolean hasCycle(ListNode head) {
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }
        while (head.next != null) {
            if (head.val == Integer.MAX_VALUE) {
                return true;
            }
            head.val = Integer.MAX_VALUE;
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        while (head.next != null) {
            if (set.contains(head.hashCode())) {
                return true;
            }
            set.add(head.hashCode());
            head = head.next;
        }
        return false;
    }
}
