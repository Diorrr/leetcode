package problems.medium;

/**
 * Problem: https://leetcode.com/problems/maximum-subarray/
 * Time Complexity: O(N)
 * Space Complexity：O(1)
 */
class Solution53 {
    public int maxSubArray(int[] nums) {
        int sum = 0, maxSum = nums[0], minSum = 0;
        for (int num : nums) {
            sum += num;
            maxSum = Math.max(sum - minSum, maxSum);
            minSum = Math.min(minSum, sum);
        }
        return Math.max(maxSum, nums[nums.length - 1]);
    }
}
