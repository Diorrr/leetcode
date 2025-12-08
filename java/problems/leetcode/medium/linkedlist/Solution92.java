package problems.leetcode.medium.linkedlist;

import problems.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href=" https://leetcode.com/problems/reverse-linked-list-ii">
 * reverse-linked-list-ii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode headCopy = head;
        List<ListNode> list = new ArrayList<>();
        while (headCopy != null) {
            list.add(headCopy);
            headCopy = headCopy.next;
        }
        left--;
        right--;
        for (int i = 0; i < (right - left + 1) / 2; i++) {
            int t = list.get(right - i).val;
            list.get(right - i).val = list.get(left + i).val;
            list.get(left + i).val = t;
        }

        return head;
    }
}
