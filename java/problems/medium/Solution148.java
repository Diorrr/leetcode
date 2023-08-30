package problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/sort-list/
 * Time Complexity: O(NlogN)
 * Space Complexity：O(N)
 */
class Solution148 {
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
