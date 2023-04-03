package problems.hard.priorityqueue;

import util.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Problem: https://leetcode.com/problems/merge-k-sorted-lists/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> allNodes = new PriorityQueue<>();
        for (ListNode list : lists) {
            ListNode node = list;
            while (node != null) {
                allNodes.add(node.val);
                node = node.next;
            }
        }
        if (allNodes.isEmpty()) {
            return null;
        }
        ListNode root = new ListNode(allNodes.poll(), new ListNode());
        ListNode curr = root;
        while (!allNodes.isEmpty()) {
            curr.next = new ListNode(allNodes.poll());
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
}
