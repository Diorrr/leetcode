package problems.leetcode.easy;

import java.util.Arrays;

/**
 * Problem: https://leetcode.com/problems/majority-element/
 * Time Complexity: O(n)
 * Space Complexity：O(1)
 */
class Solution169 {
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        return nums.length % 2 == 1 ? nums[mid] : (nums[0] == nums[mid - 1] ? nums[mid - 1] : nums[mid]);
    }

    // solution from comments with O(n) time
    public int majorityElement(int[] nums) {
        int count = 1, res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                res = nums[i];
            } else if (res == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        return res;
    }
}
