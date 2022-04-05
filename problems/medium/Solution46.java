package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/permutations/
 * Time Complexity:
 * Space Complexity：
 */
class Solution46 {
    // solution from discussions
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, boolean[] used, List<Integer> path) {
        if (path.size() == used.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < used.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(res, nums, used, path);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
