package problems.leetcode.medium.sorting;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/minimize-maximum-pair-sum-in-array">
 * minimize-maximum-pair-sum-in-array</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length / 2; i++) {
            if (res < nums[i] + nums[nums.length - 1 - i]) {
                res = nums[i] + nums[nums.length - 1 - i];
            }
        }

        return res;
    }
}
