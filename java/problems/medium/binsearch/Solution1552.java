package problems.medium.binsearch;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/magnetic-force-between-two-balls">
 * magnetic-force-between-two-balls</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1552 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 1;
        int r = (position[position.length - 1] - position[0]) / (m - 1);
        int maxMinDistance = -1;

        while (l <= r) {
            int mid = (r + l) / 2;
            if (canBePlaced(mid, position, m)) {
                maxMinDistance = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return maxMinDistance;
    }

    private boolean canBePlaced(int gap, int[] positions, int m) {
        int lastPosition = positions[0];
        int ballsRemaining = m - 1;
        for (int i = 1; i < positions.length; i++) {
            if (positions[i] - lastPosition >= gap) {
                ballsRemaining--;
                lastPosition = positions[i];
                if (ballsRemaining == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
