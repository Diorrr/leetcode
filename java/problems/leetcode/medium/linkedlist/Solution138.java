package problems.leetcode.medium.linkedlist;


import java.util.HashMap;

/**
 * Problem: <a href="https://leetcode.com/problems/copy-list-with-random-pointer">
 * copy-list-with-random-pointer</a>
 * Time Complexity: O(N)
 * Space Complexity： (N)
 */
class Solution138 {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node headCopy = new Node(0);
        headCopy.next = head;

        HashMap<Node, Node> origToCopy = new HashMap<>();
        Node newHead = new Node(head.val);
        origToCopy.put(head, newHead);

        while (head.next != null) {
            Node next = new Node(head.next.val);
            newHead.next = next;
            origToCopy.put(head.next, next);
            head = head.next;
            newHead = newHead.next;
        }

        head = headCopy.next;
        newHead = origToCopy.get(head);

        while (head != null) {
            if (head.random != null) {
                newHead.random = origToCopy.get(head.random);
            }
            head = head.next;
            newHead = newHead.next;
        }

        return origToCopy.get(headCopy.next);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
