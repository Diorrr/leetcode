package problems.hard.math;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/max-points-on-a-line">
 * max-points-on-a-line</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution149 {
    public int maxPoints(int[][] points) {
        if (points.length < 2) {
            return points.length;
        }
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String,Integer> countSlope = new HashMap<>();
            int currMax = 0;
            for (int j = i+1; j < points.length; j++) {
                int diffX = points[j][0] - points[i][0];
                int diffY = points[j][1] - points[i][1];
                int gcd = getGCD(diffX, diffY);
                diffX/=gcd;
                diffY/=gcd;
                countSlope.put(diffX + "," + diffY, countSlope.getOrDefault(diffX + "," + diffY, 0) + 1);
                currMax = Math.max(currMax, countSlope.get(diffX + "," + diffY));
            }
            res = Math.max(res, currMax + 1);
        }
        return res;
    }

    private int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }
}
