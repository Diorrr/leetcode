package problems.easy.window;


/**
 * Problem: <a href="https://leetcode.com/problems/maximum-average-subarray-i">
 * maximum-average-subarray-i</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int res = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            res = Math.max(res, sum);
        }

        return (double) res / k;
    }
}
