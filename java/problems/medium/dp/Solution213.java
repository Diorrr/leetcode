package problems.medium.dp;

/**
 * Problem: https://leetcode.com/problems/house-robber-ii/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution213 {
    public int rob(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int res1 = 0, res2 = 0;
        res1 = findMaxRob(0, nums);
        res2 = findMaxRob(1, nums);

        return Math.max(res1, res2);
    }

    private int findMaxRob(int index, int[] nums) {
        int[] dp = new int[nums.length];
        if (index == 0) {
            dp[0] = nums[0];
            dp[1] = nums[0];

        } else {
            dp[0] = 0;
            dp[1] = nums[1];
        }
        for (int i = 2; i < nums.length - (1-index); i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[dp.length - (2-index)];
    }
}
