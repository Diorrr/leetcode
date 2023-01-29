package problems.medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/combinations/
 * Time Complexity:
 * Space Complexity：
 */
class Solution77 {
    //solution from discussion
    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0 || k > n) return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 1; i <= n + 1 - k; i++) res.add(Arrays.asList(i));
        for (int i = 2; i <= k; i++) {
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            for (List<Integer> list : res) {
                for (int m = list.get(list.size() - 1) + 1; m <= n - (k - i); m++) {
                    List<Integer> newList = new ArrayList<Integer>(list);
                    newList.add(m);
                    tmp.add(newList);
                }
            }
            res = tmp;
        }
        return res;
    }

    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - k + 1; i++) {
            res.add(new ArrayList<>(Arrays.asList((i + 1))));
        }
        for (int i = 1; i < k; i++) {
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            for (List<Integer> list : res) {
                for (int j = list.get(i - 1) + 1; j < n - (k - i) + 2; j++) {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(j);
                    tmp.add(newList);
                }
            }
            res = tmp;
        }

        return res;
    }
}
