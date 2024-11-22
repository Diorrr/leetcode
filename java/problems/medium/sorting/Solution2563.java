package problems.medium.sorting;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/count-the-number-of-fair-pairs">
 * count-the-number-of-fair-pairs</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return count(nums, upper) - count(nums, lower - 1);
    }

    private long count(int[] nums, int val) {
        long res = 0;
        for (int i = 0, j = nums.length - 1; i < j; i++) {
            while (i < j && nums[i] + nums[j] > val) {
                j--;
            }
            res += j - i;
        }

        return res;
    }
}
