package problems.easy.math;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/check-if-it-is-a-straight-line">
 * check-if-it-is-a-straight-line</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 2; i < coordinates.length; i++) {
            if ((coordinates[i][1] - coordinates[0][1]) * (coordinates[1][0] - coordinates[0][0])
                    != (coordinates[1][1] - coordinates[0][1]) * (coordinates[i][0] - coordinates[0][0])) {
                return false;
            }
        }

        return true;
    }

    public boolean checkStraightLine2(int[][] coordinates) {
        boolean isParallelToY = Arrays.stream(coordinates).sequential().allMatch(t -> coordinates[0][0] == t[0]);
        if (isParallelToY) {
            return true;
        }
        double a = (double) (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
        double b = coordinates[0][1] - a * coordinates[0][0];
        for (int i = 2; i < coordinates.length; i++) {
            if (coordinates[i][1] != a * coordinates[i][0] + b) {
                return false;
            }
        }

        return true;
    }
}
