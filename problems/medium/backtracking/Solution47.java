package problems.medium.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem: https://leetcode.com/problems/permutations-ii/
 * Time Complexity:
 * Space Complexity：
 */
class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        backtrack(res, nums, new boolean[nums.length], new ArrayList<>());
        return new ArrayList<>(res);
    }

    private void backtrack(Set<List<Integer>> res, int[] nums, boolean[] used, List<Integer> path) {
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
