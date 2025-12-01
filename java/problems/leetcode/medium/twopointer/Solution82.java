package problems.leetcode.medium.twopointer;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii">
 * remove-duplicates-from-sorted-list-ii</a>
 * Time Complexity: O(N)
 * Space Complexity： O(N)
 */
class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            if (head.next == null || head.val != head.next.val) {
                list.add(head);
                head = head.next;
                list.get(list.size() - 1).next = null;
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
        if (!list.isEmpty()) {
            list.get(list.size() - 1).next = null;
        }

        return list.isEmpty() ? null : list.get(0);
    }
}
