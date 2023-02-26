package problems.medium.dfs;

import util.TreeNode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Problem: https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        Set<TreeNode> used = new HashSet<>();
        dfs(root, used);
        return used.stream().map(t -> t.val).sorted().collect(Collectors.toList()).get(k - 1);
    }

    private void dfs(TreeNode root, Set<TreeNode> used) {
        if (Objects.isNull(root)) {
            return;
        }
        used.add(root);
        if (Objects.nonNull(root.left) && !used.contains(root.left)) {
            dfs(root.left, used);
        }
        if (Objects.nonNull(root.right) && !used.contains(root.right)) {
            dfs(root.right, used);
        }
    }
}
