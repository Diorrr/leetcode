package problems.medium.binsearch;

/**
 * Problem: https://leetcode.com/problems/search-in-rotated-sorted-array
 * search-in-rotated-sorted-array</a>
 * Time Complexity: O(logN)
 * Space Complexity： O(1)
 */
class Solution33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int l = 0, r = nums.length, m = 0;
        while (l < r - 1) {
            m = (l + r) / 2;
            if (m > 0 && nums[m - 1] > nums[m]) {
                break;
            }
            if (nums[l] < nums[m]) {
                l = m;
            } else {
                r = m;
            }
        }
        l = binSearch(nums, target, 0, m - 1);
        r = binSearch(nums, target, m, nums.length - 1);

        return Math.max(l, r);
    }

    private int binSearch(int[] nums, int target, int l, int r) {
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }
}
