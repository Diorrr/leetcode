package problems.medium.linkedlist;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Problem: https://leetcode.com/problems/reverse-linked-list-ii/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        ListNode headCopy = head;
        List<ListNode> list = new ArrayList<>();
        while (Objects.nonNull(headCopy)) {
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
