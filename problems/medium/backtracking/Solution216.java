package problems.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/combination-sum-iii/
 * Time Complexity:
 * Space Complexity：
 */
class Solution216 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, 0, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int k, int target, int sum, List<Integer> list) {
        if (target == 0 && res.stream().noneMatch(t -> t.equals(list)) && list.size() == k) {
            res.add(list);
        } else if (target > 0 && list.size() < k) {
            for (int i = list.size() == 0 ? 1 : list.get(list.size() - 1); i < 10; i++) {
                if (i + 9 * (k - list.size() - 1) >= target && !list.contains(i)) {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(i);
                    backtrack(k, target - i, sum + i, newList);
                }
            }
        }
    }
}
