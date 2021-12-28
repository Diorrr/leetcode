package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/merge-intervals/
 * Time Complexity: O(N*logN)
 * Space Complexity：
 */
class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(t -> t[0]));
        List<int[]> result = new ArrayList<>();
        int compInd = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[compInd][1] >= intervals[i][0]) {
                intervals[compInd][1] = Math.max(intervals[compInd][1], intervals[i][1]);
                intervals[i][0] = -1;
                intervals[i][1] = -1;
            } else {
                compInd = i;
            }
        }
        Arrays.stream(intervals)
                .filter(t -> t[0] != -1)
                .forEach(result::add);

        return result.toArray(new int[0][]);
    }
}
