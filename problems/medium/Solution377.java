package problems.medium;

/**
 * Problem: https://leetcode.com/problems/combination-sum-iv/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}