package problems.medium.linkedlist;


import util.ListNode;

/**
 * Problem: <a href="https://leetcode.com/problems/delete-node-in-a-linked-list">
 * delete-node-in-a-linked-list</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution237 {
    public void deleteNode(ListNode node) {
        while (node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next != null ? node.next : null;
            node = node.next;
        }
    }
}
