package problems.leetcode.medium.backtracking;

/**
 * Problem: https://leetcode.com/problems/target-sum/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution494 {
    Integer res = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0);
        return res;
    }

    private void backtrack(int[] nums, int target, int index) {
        if (target == 0 && index == nums.length) {
            res++;
        } else if (index < nums.length) {
            backtrack(nums, target - nums[index], index + 1);
            backtrack(nums, target + nums[index], index + 1);
        }
    }
}
