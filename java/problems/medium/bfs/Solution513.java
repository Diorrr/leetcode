package problems.medium.bfs;


import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/find-bottom-left-tree-value">
 * find-bottom-left-tree-value</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution513 {
    public int findBottomLeftValue(TreeNode root) {
        int res = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            res = queue.peek().val;
            while (size-- > 0){
                var node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return res;
    }
}
