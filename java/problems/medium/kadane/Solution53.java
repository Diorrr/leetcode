package problems.medium.kadane;

/**
 * Problem: <a href="https://leetcode.com/problems/maximum-subarray">
 * maximum-subarray</a>
 * Time Complexity: O(N)
 * Space Complexity：O(1)
 */
class Solution53 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = nums[0];
        int minSum = 0;
        for (int num : nums) {
            sum += num;
            maxSum = Math.max(sum - minSum, maxSum);
            minSum = Math.min(minSum, sum);
        }
        return maxSum;
    }
}
