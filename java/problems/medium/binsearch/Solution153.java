package problems.medium.binsearch;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array">
 * find-minimum-in-rotated-sorted-array</a>
 * Time Complexity: O(logN)
 * Space Complexity： O(1)
 */
class Solution153 {

    public int findMin(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                return nums[i];
            }
        }

        return nums[0];
    }

    public int findMin1(int[] nums) {
        //if array is sorted i.e. isn't rotated
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        //if array is rotated
        int l = 0, r = nums.length - 1, m = 0;
        while (l < r) {
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
