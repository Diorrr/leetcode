package problems.leetcode.hard.priorityqueue;

import problems.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/merge-k-sorted-lists">
 * merge-k-sorted-lists</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution23 {
    // sol from comments
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeHelper(lists, 0, lists.length - 1);
    }

    private ListNode mergeHelper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        } else if (start + 1 == end) {
            return merge(lists[start], lists[end]);
        }

        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 != null ? l1 : l2;

        return dummy.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<ListNode> allNodes = new PriorityQueue<>(Comparator.comparing(a -> a.val));
        for (ListNode list : lists) {
            ListNode node = list;
            while (node != null) {
                allNodes.add(node);
                node = node.next;
            }
        }
        if (allNodes.isEmpty()) {
            return null;
        }
        ListNode root = allNodes.poll();
        ListNode curr = root;
        while (!allNodes.isEmpty()) {
            curr.next = allNodes.poll();
            curr = curr.next;
        }
        curr.next = null;

        return root;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        List<ListNode> allNodes = new ArrayList<>();
        for (ListNode list : lists) {
            ListNode node = list;
            while (node != null) {
                allNodes.add(node);
                node = node.next;
            }
        }
        if (allNodes.isEmpty()) {
            return null;
        }
        allNodes.sort(Comparator.comparingInt(a -> a.val));
        ListNode root = new ListNode(allNodes.get(0).val, new ListNode());
        ListNode curr = root;
        for (int i = 1; i < allNodes.size(); i++) {
            curr.next = new ListNode(allNodes.get(i).val);
            curr = curr.next;
        }
        curr.next = null;

        return root;
    }

    public ListNode mergeKLists3(ListNode[] lists) {
        ListNode res = null;
        int val = Integer.MAX_VALUE;
        int pos = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < val) {
                val = lists[i].val;
                pos = i;
            }
        }
        if (pos != -1) {
            lists[pos] = lists[pos].next;
            res = new ListNode(val, mergeKLists(lists));
        }

        return res;
    }
}
