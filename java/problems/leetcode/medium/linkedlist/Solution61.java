package problems.leetcode.medium.linkedlist;

import problems.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/rotate-list/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution61 {
    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        k %= list.size();
        if (k == 0) {
            return list.get(0);
        }
        list.get(list.size() - 1 - k).next = null;
        list.get(list.size() - 1).next = list.get(0);
        return list.get(list.size() - k);
    }

    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        k %= list.size();
        for (int i = 0; i < k; i++) {
            int last = list.get(0).val;
            for (int j = 1; j < list.size(); j++) {
                int temp = list.get(j).val;
                list.get(j).val = last;
                last = temp;
            }
            list.get(0).val = last;
        }

        return list.get(0);
    }
}
