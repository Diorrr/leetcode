package problems.leetcode.medium.linkedlist;

import problems.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/split-linked-list-in-parts">
 * split-linked-list-in-parts</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        ListNode[] res = new ListNode[k];
        int pos = 0;
        int rem = list.size() % k;
        for (int i = 0; i < k && pos < list.size(); i++) {
            res[i] = list.get(pos);
            pos += list.size() / k + (rem > 0 ? 1 : 0);
            rem--;
            list.get(pos - 1).next = null;
        }

        return res;
    }
}
