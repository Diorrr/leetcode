package problems.leetcode.medium.math;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/minimum-time-difference">
 * minimum-time-difference</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution539 {
    public int findMinDifference(List<String> timePoints) {
        boolean[] minutes = new boolean[24 * 60];
        int res = Integer.MAX_VALUE;
        for (String timePoint : timePoints) {
            String[] split = timePoint.split(":");
            int minute = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            if (minutes[minute]) {
                return 0;
            }
            minutes[minute] = true;
        }
        int prev = 0;
        int first = Integer.MAX_VALUE;
        int last = Integer.MIN_VALUE;
        for (int i = 0; i < 24 * 60; i++) {
            if (minutes[i]) {
                if (first != Integer.MAX_VALUE) {
                    res = Math.min(i - prev, res);
                } else {
                    first = i;
                }
                last = i;
                prev = i;
            }
        }
        return Math.min(24 * 60 - last + first, res);
    }

    public int findMinDifference2(List<String> timePoints) {
        List<Integer> minutes = new LinkedList<>();
        for (String timePoint : timePoints) {
            int min = Integer.parseInt(timePoint.substring(0, 2)) * 60 + Integer.parseInt(timePoint.substring(3));
            minutes.add(min);
        }
        Collections.sort(minutes);
        int res = 1440 - minutes.get(minutes.size() - 1) + minutes.get(0);
        for (int i = 1; i < minutes.size(); i++) {
            res = Math.min(minutes.get(i) - minutes.get(i - 1), res);
        }

        return res;
    }
}
