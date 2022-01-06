package problems.easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/merge-two-sorted-lists/
 * Time Complexity: O(N)
 * Space Complexity：
 */
class Solution21 {
    //Definition for singly-linked list.
    private static class ListNode {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode start = new ListNode();
        ListNode pred = new ListNode(-1, start);
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                start.val = list1.val;
                start.next = list1.next;
                list1 = list1.next;
            } else {
                start.val = list2.val;
                start.next = list2.next;
                list2 = list2.next;
            }
            while (list1 != null || list2 != null) {
                if (list1 == null) {
                    start.next = list2;
                    break;
                } else if (list2 == null) {
                    start.next = list1;
                    break;
                } else {
                    if (list1.val < list2.val) {
                        start.next = list1;
                        list1 = list1.next;
                    } else {
                        start.next = list2;
                        list2 = list2.next;
                    }
                    start = start.next;
                }
            }

            return pred.next;
        } else if (list1 != null) {
            return list1;
        } else {
            return list2;
        }
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        List<ListNode> list = new ArrayList<>();
        while (list1 != null || list2 != null) {
            if (list1 != null) {
                list.add(list1);
                list1 = list1.next;
            }
            if (list2 != null) {
                list.add(list2);
                list2 = list2.next;
            }
        }
        list.sort(Comparator.comparingInt(a -> a.val));
        for (int i = 1; i < list.size(); i++) {
            list.get(i - 1).next = list.get(i);
        }

        return list.size() > 0 ? list.get(0) : null;
    }
}
