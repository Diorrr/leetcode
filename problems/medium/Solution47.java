package problems.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Problem: https://leetcode.com/problems/permutations-ii/
 * Time Complexity:
 * Space Complexity：
 */
class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        dfs(res, nums, new boolean[nums.length], new ArrayList<>());
        return new ArrayList<>(res);
    }

    private void dfs(Set<List<Integer>> res, int[] nums, boolean[] used, List<Integer> path) {
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
