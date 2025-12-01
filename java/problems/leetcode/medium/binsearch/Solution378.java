package problems.leetcode.medium.binsearch;

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
        int n = matrix[0].length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = count(matrix, mid);
            if (count < k) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        return left;
    }

    private int count(int[][] matrix, int mid) {
        int count = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length && matrix[i][j] <= mid; j++) {
                count++;
            }
        }

        return count;
    }

    public int kthSmallest2(int[][] matrix, int k) {
        List<Integer> list = new ArrayList<Integer>();
        for (int[] array : matrix) {
            list.addAll(Arrays.stream(array).boxed().collect(Collectors.toList()));
        }
        list.sort(Integer::compare);

        return list.get(k - 1);
    }
}
