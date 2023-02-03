package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Problem: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        List<Integer> list = new ArrayList<Integer>();
        for (int[] array : matrix) {
            list.addAll(Arrays.stream(array).boxed().collect(Collectors.toList()));
        }
        list.sort(Integer::compare);

        return list.get(k - 1);
    }
}
