package problems.medium.prefixsum;

import java.util.Arrays;
import java.util.Collections;

/**
 * Problem: https://leetcode.com/problems/product-of-array-except-self/
 * Time Complexity: O(3N)
 * Space Complexity：O(3N)
 */
class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            Collections.reverse(Arrays.asList(nums));
            return nums;
        }

        int[] res = new int[nums.length];
        int[] pref = new int[nums.length];
        int[] suf = new int[nums.length];
        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            pref[i] = prod;
        }
        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prod *= nums[i];
            suf[i] = prod;
        }
        res[0] = suf[1];
        res[nums.length - 1] = pref[nums.length-2];
        for (int i = 1; i < nums.length-1; i++) {
            res[i]=pref[i-1]*suf[i+1];
        }

        return res;
    }
}
