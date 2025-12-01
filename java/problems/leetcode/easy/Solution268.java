package problems.leetcode.easy;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/missing-number">
 * missing-number</a>
 * Time Complexity: O(N)
 * Space Complexity： O(1)
 */
class Solution268 {
    public int missingNumber(int[] nums) {
        int res = nums.length * (nums.length + 1) / 2;
        for (int num : nums) {
            res -= num;
        }
        return res;
    }

    public int missingNumber2(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length - 1] == nums.length - 1) {
            return nums.length;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i) {
                    return i;
                }
            }
        }
        return 0;
    }
}
