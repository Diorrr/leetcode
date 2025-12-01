package problems.leetcode.medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/combination-sum-ii">combination-sum-ii</a>
 * combination-sum-ii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution40 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] candidates, int target, int index, List<Integer> list) {
        if (target == 0) {
            res.add(list);
        } else if (target > 0) {
            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) continue;
                List<Integer> newList = new ArrayList<>(list);
                newList.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i + 1, newList);
            }
        }
    }

    public List<List<Integer>> combinationSum22(int[] candidates, int target) {
        Arrays.sort(candidates);
        findComb(candidates, target, 0, new LinkedList<>());
        return res.stream().toList();
    }

    private void findComb(int[] candidates, int target, int index, LinkedList<Integer> currSet) {
        if (target == 0) {
            res.add(new LinkedList<>(currSet));
        } else if (target > 0) {
            for (int i = index; i < candidates.length; i++) {
                if (i == index || candidates[i] != candidates[i - 1]) {
                    currSet.addLast(candidates[i]);
                    findComb(candidates, target - candidates[i], i + 1, currSet);
                    currSet.removeLast();
                }
            }
        }
    }
}
