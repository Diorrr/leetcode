package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * Time Complexity: O(N)
 * Space Complexity： O(N)
 */
class Solution82 {
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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();

        while (head != null) {
            if (isNextUnique(head)) {
                list.add(head);
                head = head.next;
            } else {
                int val = head.val;
                while (head != null && head.val == val) {
                    head = head.next;
                }
            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        if (list.size() > 0) {
            list.get(list.size() - 1).next = null;
        }

        return list.size() == 0 ? null : list.get(0);
    }

    private boolean isNextUnique(ListNode cur) {
        return cur.next == null || cur.val != cur.next.val;
    }
}
