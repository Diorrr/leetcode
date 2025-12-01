package problems.leetcode.medium.pointer;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/reorder-list">
 * reorder-list</a>
 * Time Complexity: O(N)
 * Space Complexity： O(N)
 */
class Solution143 {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            list.get(i).next = list.get(list.size() - 1 - i);
            list.get(list.size() - 1 - i).next = i == list.size() / 2 - 1 ? null : list.get(i + 1);
            if (list.size() % 2 == 0 && i + 1 == list.size() / 2) {
                list.get(list.size() - 1 - i).next = list.get(i + 1);
                list.get(i + 1).next = null;
            }
        }
    }
}
