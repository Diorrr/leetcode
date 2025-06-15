package problems.medium.graph;

import util.Node;

/**
 * Problem: <a href="https://leetcode.com/problems/clone-graph">
 * clone-graph</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution133 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node deepCopy = new Node(node.val);
        Node[] copyArray = new Node[101];
        copyArray[deepCopy.val] = deepCopy;
        boolean[] used = new boolean[101];
        dfs(node, used, deepCopy, copyArray);

        return deepCopy;
    }

    private void dfs(Node node, boolean[] used, Node deepCopy, Node[] copyArray) {
        used[node.val] = true;
        copyArray[deepCopy.val] = deepCopy;
        for (Node neighbor : node.neighbors) {
            if (!used[neighbor.val]) {
                Node copy = new Node(neighbor.val);
                deepCopy.neighbors.add(copy);
                copyArray[copy.val] = copy;
                dfs(neighbor, used, copy, copyArray);
            } else {
                deepCopy.neighbors.add(copyArray[neighbor.val]);
            }
        }
    }
}
