package problems.easy;

import util.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/merge-two-sorted-lists">
 * merge-two-sorted-lists"</a>
 * Time Complexity: O(N)
 * Space Complexity：
 */
class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode start = new ListNode();
        ListNode pred = new ListNode(-1, start);
        sortNodes(start, list1, list2);

        return pred.next;
    }

    private void sortNodes(ListNode start, ListNode list1, ListNode list2) {
        if (list1 != null && list2 == null) {
            start.val = list1.val;
            start.next = list1.next;
        } else if (list1 == null && list2 != null) {
            start.val = list2.val;
            start.next = list2.next;
        } else if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                start.val = list1.val;
                list1 = list1.next;
            } else {
                start.val = list2.val;
                list2 = list2.next;
            }
            start.next = new ListNode();
            sortNodes(start.next, list1, list2);
        }
    }

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
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

        return list.isEmpty() ? null : list.get(0);
    }
}
