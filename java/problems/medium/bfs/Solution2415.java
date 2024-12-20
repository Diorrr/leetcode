package problems.medium.bfs;


import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/reverse-odd-levels-of-binary-tree">
 * reverse-odd-levels-of-binary-tree</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2415 {
    public TreeNode reverseOddLevels(TreeNode root) {
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        boolean isRevert = false;
        while (!level.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<>();
            for (TreeNode node : level) {
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            isRevert = !isRevert;
            if (isRevert) {
                for (int i = 0; i < nextLevel.size() / 2; i++) {
                    int temp = nextLevel.get(i).val;
                    nextLevel.get(i).val = nextLevel.get(nextLevel.size() - 1 - i).val;
                    nextLevel.get(nextLevel.size() - 1 - i).val = temp;
                }
            }
            level = nextLevel;
        }

        return root;
    }
}
