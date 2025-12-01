package problems.leetcode.easy.array;

/**
 * Problem: <a href="https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array">
 * maximum-difference-between-adjacent-elements-in-a-circular-array</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3423 {
    public int maxAdjacentDistance(int[] nums) {
        int max = Math.abs(nums[0] - nums[nums.length - 1]);
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, Math.abs(nums[i] - nums[i - 1]));
        }
        return max;
    }
}
