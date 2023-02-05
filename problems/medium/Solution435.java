package problems.medium;

import java.util.Arrays;

/**
 * Problem: https://leetcode.com/problems/non-overlapping-intervals/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 1, index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[index][1] <= intervals[i][0]) {
                index = i;
                count++;
            }
        }

        return intervals.length - count;
    }
}
