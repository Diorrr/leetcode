package problems.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/palindrome-linked-list/
 * Time Complexity:
 * Space Complexity：
 */
class Solution234 {
    //Definition for singly-linked list.
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head, prev = null, slowNext = null, first, second;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            slowNext = slow.next;
            slow.next = prev;
            prev = slow;
            slow = slowNext;
        }
        first = prev;
        second = (fast == null) ? slow : slow.next;
        while (first != null && second != null) {
            if (first.val != second.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }

        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i).val != list.get(list.size() - 1 - i).val) {
                return false;
            }
        }
        return true;
    }
}
