package problems.leetcode.medium.linkedlist;


import problems.leetcode.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: <a href="https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array">
 * delete-nodes-from-linked-list-present-in-array</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3217 {
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode res = new ListNode(0, head);
        ListNode prev = res;
        ListNode cur = head;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        while (cur != null) {
            if (numSet.contains(cur.val)) {
                prev.next = null;
            } else {
                prev.next = cur;
                prev = cur;
            }
            cur = cur.next;
        }

        return res.next;
    }
}
