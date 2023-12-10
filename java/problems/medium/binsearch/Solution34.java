package problems.medium.binsearch;

/**
 * Problem: <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array">
 * find-first-and-last-position-of-element-in-sorted-array</a>
 * Time Complexity: O(logN)
 * Space Complexity： O(1)
 */
class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int l = 0;
        int r = nums.length - 1;
        int m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target && (m == 0 || nums[m - 1] != target)) {
                res[0] = m;
                break;
            }
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target && (m == nums.length - 1 || nums[m + 1] != target)) {
                res[1] = m;
                break;
            }
            if (nums[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return res;
    }
}
