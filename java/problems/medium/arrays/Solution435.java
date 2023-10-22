package problems.medium.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem: <a href="https://leetcode.com/problems/non-overlapping-intervals">
 * non-overlapping-intervals</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 1;
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[index][1] <= intervals[i][0]) {
                index = i;
                count++;
            }
        }

        return intervals.length - count;
    }
}
