package problems.leetcode.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/permutations
 * permutations</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution46 {
    // solution from discussions
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, boolean[] used, List<Integer> path) {
        if (path.size() == used.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                backtrack(res, nums, used, path);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
