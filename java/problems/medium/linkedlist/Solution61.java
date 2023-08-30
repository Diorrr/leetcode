package problems.medium.linkedlist;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Problem: https://leetcode.com/problems/rotate-list/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (Objects.isNull(head)) {
            return head;
        }

        List<ListNode> list = new ArrayList<>();
        while (Objects.nonNull(head)) {
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
