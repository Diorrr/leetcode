package problems.easy;

/**
 * Problem: https://leetcode.com/problems/first-bad-version/
 * Time Complexity: O(logN)
 * Space Complexity： O(1)
 */
class Solution278 {
    public int firstBadVersion(int n, int target) {
        if (n == 1) {
            return 1;
        } else {
            long l = 0, r = n;
            long m;
            while (l < r - 1) {
                m = (l + r) / 2;
                if (m>target){//isBadVersion((int) m)) {
                    r = m;
                } else {
                    l = m;
                }
            }
            return (int) r;
        }
    }
}
