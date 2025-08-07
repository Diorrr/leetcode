package problems.medium.kadane;

/**
 * Problem: <a href="https://leetcode.com/problems/maximum-sum-circular-subarray">
 * maximum-sum-circular-subarray</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution918 {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        int maxSum = nums[0];
        int minSum = nums[0];
        int maxCur = 0;
        int minCur = 0;
        for (int num : nums) {
            maxCur = Math.max(maxCur + num, num);
            maxSum = Math.max(maxCur, maxSum);
            minCur = Math.min(minCur + num, num);
            minSum = Math.min(minCur, minSum);
            sum += num;
        }
        return maxSum > 0 ? Math.max(maxSum, sum - minSum) : maxSum;
    }

    public static void main(String[] args) {

    }
}
