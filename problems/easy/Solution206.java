package problems.easy;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/reverse-linked-list/
 * Time Complexity: O(N)
 * Space Complexity： O(1) / O(N)
 */
class Solution206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pred = null, temp;
        while (head != null) {
            temp = head.next;
            head.next = pred;
            pred = head;
            head = temp;
        }

        return pred;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return head;
        }

        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        for (int i = 1; i < list.size(); i++) {
            list.get(i).next = list.get(i - 1);
        }

        return list.get(list.size() - 1);
    }
}
