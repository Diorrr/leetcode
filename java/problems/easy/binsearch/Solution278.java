package problems.easy.binsearch;

/**
 * Problem: <a href="https://leetcode.com/problems/first-bad-version">
 * first-bad-version</a>
 * Time Complexity: O(logN)
 * Space Complexity： O(1)
 */
class Solution278 {
    public int firstBadVersion(int n, int target) {
        if (n == 1) {
            return 1;
        } else {
            long l = 0, r = n;
            long mid;
            while (l <= r) {
                mid = (l + r) / 2;
                if (mid > target) {//isBadVersion((int)mid)) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return (int) l;
        }
    }
}
