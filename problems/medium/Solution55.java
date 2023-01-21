package problems.medium;

import java.util.Arrays;

/**
 * Problem: https://leetcode.com/problems/jump-game/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution55 {
    public boolean canJump(int[] nums) {
        if (Arrays.stream(nums).sum() < nums.length - 1) {
            return false;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] == 1 && j + nums[j] >= i) {
                    dp[i] = 1;
                    break;
                }
            }
        }

        return dp[nums.length - 1] == 1;
    }
}
