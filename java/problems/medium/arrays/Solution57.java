package problems.medium.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/insert-interval/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            res.add(newInterval);
            int[][] finalRes = new int[res.size()][];
            return res.toArray(finalRes);
        }
        int start = newInterval[0], end = newInterval[1];
        int index = 0;
        for (; index < intervals.length && intervals[index][1] < start; index++) {
            res.add(intervals[index]);
        }

        for (; index < intervals.length && intervals[index][0] <= end; index++) {
            start = Math.min(start, intervals[index][0]);
            end = Math.max(end, intervals[index][1]);
        }
        res.add(new int[]{start, end});

        for (; index < intervals.length; index++) {
            res.add(intervals[index]);
        }

        int[][] finalRes = new int[res.size()][];
        return res.toArray(finalRes);
    }
}
