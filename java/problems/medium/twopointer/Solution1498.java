package problems.medium.twopointer;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition">
 * number-of-subsequences-that-satisfy-the-given-sum-condition</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1498 {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0, mod = (int) 1e9 + 7;
        int[] pows = new int[nums.length];
        pows[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            pows[i] = pows[i - 1] * 2 % mod;
        }
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                res = (res + pows[r - l++]) % mod;
            } else {
                r--;
            }
        }

        return res;
    }
}
