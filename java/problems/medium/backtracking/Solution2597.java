package problems.medium.backtracking;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/the-number-of-beautiful-subsets">
 * the-number-of-beautiful-subsets</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2597 {
    int res = 0;

    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int[] count = new int[nums[nums.length - 1] + 1];
        backtrack(nums, k, count, 0);
        return res;
    }

    private void backtrack(int[] nums, int k, int[] count, int index) {
        if (index < nums.length) {
            if (nums[index] < k || (nums[index] - k >= 0 && count[nums[index] - k] == 0)) {
                count[nums[index]]++;
                res++;
                backtrack(nums, k, count, index + 1);
                count[nums[index]]--;
            }
            backtrack(nums, k, count, index + 1);
        }
    }
}
