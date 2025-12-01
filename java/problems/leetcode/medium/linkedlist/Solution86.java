package problems.leetcode.medium.linkedlist;

import util.ListNode;

/**
 * Problem: <a href="https://leetcode.com/problems/partition-list">
 * partition-list</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode leftHead = left;
        ListNode rightHead = right;

        while (head != null) {
            if (head.val < x) {
                leftHead.next = head;
                leftHead = leftHead.next;
            } else {
                rightHead.next = head;
                rightHead = rightHead.next;
            }
            head = head.next;
        }
        leftHead.next = right.next;
        rightHead.next = null;
        return left.next;
    }
}
