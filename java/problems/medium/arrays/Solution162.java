package problems.medium.arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/find-peak-element">
 * find-peak-element</a>
 * Time Complexity: O(N)
 * Space Complexity： O(1)
 */
class Solution162 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1 || nums[0] > nums[1]) {
            return 0;
        } else if (nums[nums.length - 2] < nums[nums.length - 1]) {
            return nums.length - 1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if ((m == nums.length - 1 || nums[m] > nums[m + 1]) && nums[m - 1] < nums[m]) {
                return m;
            }

            if (nums[m] < nums[m + 1]) {
                l = m;
            } else {
                r = m;
            }
        }

        return -1;
    }

    public int findPeakElement2(int[] nums) {

        if (nums == null) {
            return -1;
        } else if (nums.length == 1 || nums[0] > nums[1]) {
            return 0;
        } else if (nums[nums.length - 2] < nums[nums.length - 1]) {
            return nums.length - 1;
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                return i;
            }
        }

        return -1;
    }
}
