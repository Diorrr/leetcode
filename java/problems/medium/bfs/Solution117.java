package problems.medium.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii">
 * populating-next-right-pointers-in-each-node-ii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution117 {
    public Node connect(Node root) {
        if (root != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                List<Node> level = new ArrayList<>();
                while (!queue.isEmpty()) {
                    Node curr = queue.poll();
                    curr.next = queue.peek();
                    if (curr.left != null) {
                        level.add(curr.left);
                    }
                    if (curr.right != null) {
                        level.add(curr.right);
                    }
                }
                queue.addAll(level);
            }
        }

        return root;
    }

    class Node {
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
}
