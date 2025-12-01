package problems.leetcode.easy.dfs;


import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/n-ary-tree-postorder-traversal">
 * n-ary-tree-postorder-traversal</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution590 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return res;
        }
        for (Node child : root.children) {
            postorder(child);
        }
        res.add(root.val);
        return res;
    }

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
}
