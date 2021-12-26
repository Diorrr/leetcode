package problems;

import java.util.Arrays;

/**
 * Problem: https://leetcode.com/problems/squares-of-a-sorted-array/
 * Time Complexity:
 * Space Complexity：
 */
class Solution977 {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
