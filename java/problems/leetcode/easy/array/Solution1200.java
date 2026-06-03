package problems.leetcode.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/minimum-absolute-difference">
 * minimum-absolute-difference</a>
 * Time Complexity: O(n log n)
 * Space Complexity：
 */
class Solution1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == minDiff) {
                res.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return res;
    }


    public List<List<Integer>> minimumAbsDifference2(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff < minDiff) {
                minDiff = diff;
                res.clear();
                res.add(List.of(arr[i - 1], arr[i]));
            } else if (diff == minDiff) {
                res.add(List.of(arr[i - 1], arr[i]));
            }
        }
        return res;
    }
}
