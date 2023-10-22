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
