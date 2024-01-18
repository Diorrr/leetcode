package problems.medium.intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem: <a href="https://leetcode.com/problems/merge-intervals">
 * merge-intervals</a>
 * Time Complexity: O(N*logN)
 * Space Complexity：
 */
class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(t -> t[0]));
        int compInd = 0;
        int mergeCount = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[compInd][1] >= intervals[i][0]) {
                intervals[compInd][1] = Math.max(intervals[compInd][1], intervals[i][1]);
                intervals[i][0] = -1;
                intervals[i][1] = -1;
                mergeCount++;
            } else {
                compInd = i;
            }
        }

        int pos = 0;
        int[][] res = new int[intervals.length - mergeCount][];
        for (int[] interval : intervals) {
            if (interval[0] != -1) {
                res[pos++] = interval;
            }
        }

        return res;
    }
}
