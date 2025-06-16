package problems.medium.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.ListNode;

/**
 * Problem: <a href="https://leetcode.com/problems/sort-list">
 * sort-list</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 != null ? l1 : l2;

        return dummy.next;
    }

    public ListNode sortList2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode headCopy = head;
        while (headCopy != null) {
            list.add(headCopy.val);
            headCopy = headCopy.next;
        }

        Collections.sort(list);
        ListNode cur = head;
        for (Integer integer : list) {
            cur.val = integer;
            cur = cur.next;
        }

        return head;
    }
}
