package problems.medium.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/combination-sum">
 * combination-sum</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution39 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> currRes = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int ind) {
        if (target == 0) {
            res.add(new ArrayList<>(currRes));
        } else {
            for (int i = ind; i < candidates.length; i++) {
                if (target >= candidates[i]) {
                    currRes.add(candidates[i]);
                    backtrack(candidates, target - candidates[i], i);
                    currRes.removeLast();
                }
            }
        }
    }

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
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

    public static void main(String[] args) {
        var res = new Solution39().combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println();
    }
}
