package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/combination-sum/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution39 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, List<Integer> list, int index) {
        if (target == 0) {
            res.add(list);
        } else if (target > 0) {
            for (int i = index; i < candidates.length; i++) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(candidates[i]);
                backtrack(candidates, target - candidates[i], newList, i);
            }
        }
    }
}
