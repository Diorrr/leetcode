package problems.medium;

import util.ListNode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Problem: https://leetcode.com/problems/linked-list-cycle-ii/description/
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
