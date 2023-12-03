package problems.easy.set;


import util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: <a href="https://leetcode.com/problems/intersection-of-two-linked-lists">
 * intersection-of-two-linked-lists</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
