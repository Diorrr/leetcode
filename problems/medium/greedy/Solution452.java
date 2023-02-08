package problems.medium.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int count = 1;
        int arrow = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > arrow) {
                count++;
                arrow = points[i][1];
            }
        }

        return count;
    }
}
