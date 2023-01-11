package problems.medium;

/**
 * Problem: https://leetcode.com/problems/target-sum/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution494 {
    Integer res = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, new int[nums.length]);
        return res;
    }

    private void backtrack(int[] nums, int target, int index, int[] used) {
        if (target == 0 && index == nums.length) {
            res++;
        } else if (index< nums.length){
            backtrack(nums, target - nums[index], index + 1, used);
            backtrack(nums, target + nums[index], index + 1, used);
        }
    }
}
