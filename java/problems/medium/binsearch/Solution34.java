package problems.medium.binsearch;

/**
 * Problem: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * Time Complexity: O(logN)
 * Space Complexity： O(1)
 */
class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int l = -1, r = nums.length, m = 0;
        while (l < r - 1) {
            m = (l + r) / 2;
            if (nums[m] == target && (m == 0 || nums[m - 1] != target)) {
                res[0] = m;
                break;
            }
            if (nums[m] < target) {
                l = m;
            } else {
                r = m;
            }
        }

        l = -1;
        r = nums.length;
        while (l < r - 1) {
            m = (l + r) / 2;
            if (nums[m] == target && (m == nums.length - 1 || nums[m + 1] != target)) {
                res[1] = m;
                break;
            }
            if (nums[m] <= target) {
                l = m;
            } else {
                r = m;
            }
        }

        return res;
    }
}
