package problems.easy;

import java.util.Arrays;

/**
 * Problem: https://leetcode.com/problems/missing-number/
 * Time Complexity: O(N*logN)
 * Space Complexity：
 */
class Solution268 {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] != 0) {
            return 0;
        } else if (nums[nums.length - 1] == nums.length - 1) {
            return nums.length;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i) {
                    return i;
                }
            }
        }
        return 0;
    }
}
