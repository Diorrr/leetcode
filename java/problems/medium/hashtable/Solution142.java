package problems.medium.hashtable;

import util.ListNode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Problem: <a href="https://leetcode.com/problems/linked-list-cycle-ii">
 * linked-list-cycle-ii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (Objects.nonNull(head) && Objects.nonNull(head.next)) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
