package problems.medium.binsearch;

import java.util.Arrays;

/**
 * Problem: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * Time Complexity: O(logN)
 * Space Complexity： O(1)
 */
class Solution153 {

    public int findMin(int[] nums) {
        //if array is sorted i.e. isn't rotated
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        //if array is rotated
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

        return nums[m];
    }

    // java stream solution
    public int findMin2(int[] nums) {
        return Arrays.stream(nums).min().getAsInt();
    }
}
