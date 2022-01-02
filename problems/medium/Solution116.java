package problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * Time Complexity: O(N)
 * Space Complexity：
 */
class Solution116 {
    // Definition for a Node.
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node node;
        Queue<Node> queue = new LinkedList<>();
        int count = 0, power = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            count++;
            node = queue.poll();
            if ((count & (count + 1)) == 0) {
                node.next = null;
            } else {
                node.next = queue.peek();
            }
            if (node.left != null && node.right != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return root;
    }

    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            list.add(node);
            if (node.left != null && node.right != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        int power = 1, start = 0;
        while (power < list.size()) {
            for (int i = start; i < start + power - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }
            list.get(start + power - 1).next = null;
            power *= 2;
            start = power - 1;
        }

        return root;
    }
}
