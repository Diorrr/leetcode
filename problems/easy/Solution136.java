package problems.easy;

import java.util.Arrays;

/**
 * Problem: https://leetcode.com/problems/single-number/
 * Time Complexity: O(NlogN)
 * Space Complexity： O(1)
 */
class Solution136 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i += 2) {
            if (nums[i - 1] != nums[i]) {
                return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }

    // solution from discussions with XOR
    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }

}
