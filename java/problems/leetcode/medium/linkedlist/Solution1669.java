package problems.leetcode.medium.linkedlist;


import problems.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/merge-in-between-linked-lists">
 * merge-in-between-linked-lists</a>
 * Time Complexity: O(N)
 * Space Complexity：
 */
class Solution1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        while (a > 1) {
            list1 = list1.next;
            a--;
            b--;
        }
        ListNode nodeA = list1;
        while (b >= 0) {
            list1 = list1.next;
            b--;
        }
        nodeA.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = list1;

        return head;
    }

    public ListNode mergeInBetween1(ListNode list1, int a, int b, ListNode list2) {
        List<ListNode> listNodes1 = new ArrayList<>();
        while (list1 != null) {
            listNodes1.add(list1);
            list1 = list1.next;
        }
        listNodes1.get(a - 1).next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = listNodes1.get(b + 1);

        return listNodes1.get(0);
    }
}
