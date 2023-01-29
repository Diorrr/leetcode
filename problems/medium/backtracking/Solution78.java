package problems.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/subsets/
 * Time Complexity:
 * Space Complexity：
 */
class Solution78 {
    // solution from comments
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> list, int start) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(res, nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int size = (1 << nums.length);
        for (int i = 0; i < size; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            res.add(subset);
        }

        return res;
    }
}
