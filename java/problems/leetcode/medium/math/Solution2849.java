package problems.leetcode.medium.math;


/**
 * Problem: <a href="https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time">
 * determine-if-a-cell-is-reachable-at-a-given-time</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2849 {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int dist = Math.max(Math.abs(sx - fx), Math.abs(sy - fy));
        return dist == 0 ? t == 0 || t > 1 : dist <= t;
    }
}
