package problems.medium;

/**
 * Problem: https://leetcode.com/problems/house-robber/
 * Time Complexity:
 * Space Complexity：
 */
class Solution198 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            res[i] = Math.max(res[i - 2] + nums[i], res[i - 1]);
        }

        return res[res.length - 1];
    }
}
