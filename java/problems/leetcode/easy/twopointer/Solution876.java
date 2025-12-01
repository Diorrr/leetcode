package problems.leetcode.easy.twopointer;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/middle-of-the-linked-list">
 * middle-of-the-linked-list</a>
 * Time Complexity: O(N)
 * Space Complexity：
 */
class Solution876 {

    public ListNode middleNode(ListNode head) {
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode middleNode2(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        list.add(head);
        ListNode next = head.next;
        while (next != null) {
            list.add(next);
            next = next.next;
        }

        return list.get(list.size() / 2);
    }
}
