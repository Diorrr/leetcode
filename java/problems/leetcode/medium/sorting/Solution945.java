package problems.leetcode.medium.sorting;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/minimum-increment-to-make-array-unique">
 * minimum-increment-to-make-array-unique</a>
 * Time Complexity: O(N logN)
 * Space Complexity：
 */
class Solution945 {
    public int minIncrementForUnique(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        int used = nums[0] - 1;
        for (int num : nums) {
            if (used > num) {
                res += used - num;
            }
            used = Math.max(used, num) + 1;
        }
        return res;
    }
}
