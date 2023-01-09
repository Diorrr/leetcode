package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/combination-sum-ii/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution40 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int[] candidates, int target, int index, List<Integer> list) {
        if (target == 0 && !res.stream().anyMatch(t->t.equals(list))) {
            res.add(list);
        } else if (target > 0) {
            for (int i = index; i < candidates.length; i++) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i + 1, newList);
            }
        }
    }
}
