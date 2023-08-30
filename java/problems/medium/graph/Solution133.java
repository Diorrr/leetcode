package problems.medium.graph;

import util.Node;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Problem: https://leetcode.com/problems/clone-graph/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution133 {
    public Node cloneGraph(Node node) {
        if (Objects.isNull(node)) {
            return null;
        }
        Node deepCopy = new Node(node.val);
        Node[] copyArray = new Node[101];
        copyArray[deepCopy.val] = deepCopy;
        Set<Node> used = new HashSet<>();
        dfs(node, used, deepCopy, copyArray);

        return deepCopy;
    }

    private void dfs(Node node, Set<Node> used, Node deepCopy, Node[] copyArray) {
        used.add(node);
        copyArray[deepCopy.val] = deepCopy;
        for (Node neighbor : node.neighbors) {
            if (!used.contains(neighbor)) {
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
