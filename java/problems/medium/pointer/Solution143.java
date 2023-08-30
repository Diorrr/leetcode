package problems.medium.pointer;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Problem: https://leetcode.com/problems/reorder-list/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution143 {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (Objects.nonNull(head)) {
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
