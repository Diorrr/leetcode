package problems.easy.twopointer;

import util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: https://leetcode.com/problems/linked-list-cycle/
 * Time Complexity: O(N)
 * Space Complexity： O(1)
 */
class Solution141 {
    public boolean hasCycle(ListNode head) {
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
