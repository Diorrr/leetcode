package problems.leetcode.medium.binsearch;

/**
 * Problem: <a href="https://leetcode.com/problems/minimum-speed-to-arrive-on-time">
 * minimum-speed-to-arrive-on-time</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1870 {
    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 0;
        int r = Integer.MAX_VALUE, m = 0;
        while (l < r - 1) {
            m = (l + r) / 2;
            if (m == 0) {
                break;
            }
            boolean check = check(dist, hour, m);
            if (m > 1 && check && !check(dist, hour, m - 1)) {
                return m;
            } else if (m == 1 && check) {
                return 1;
            }
            if (check) {
                r = m;
            } else {
                l = m;
            }
        }

        return -1;
    }

    boolean check(int[] dist, double hour, int speed) {
        double hoursNeeded = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            int distance = dist[i];
            hoursNeeded += distance % speed == 0 ? (double) distance / speed : Math.ceil(((double) distance) / speed);
        }
        hoursNeeded += (double) dist[dist.length - 1] / speed;
        return hour >= hoursNeeded;
    }
}
