package problems.medium.twopointer;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation">
 * maximum-beauty-of-an-array-after-applying-operation</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2779 {
    public int maximumBeauty(int[] nums, int k) {
        int res = 1;
        int start = 0;
        Arrays.sort(nums);
        for (int end = 0; end < nums.length; end++) {
            while (nums[end] - nums[start] > 2 * k) {
                start++;
            }
            res = Math.max(end - start, res);
        }

        return res;
    }

    public int maximumBeauty2(int[] nums, int k) {
        int res = 1;
        int l = 0;
        int r = 1;
        Arrays.sort(nums);
        while (l <= r && r < nums.length) {
            if (nums[l] + 2 * k >= nums[r]) {
                res = Math.max(res, r - l + 1);
                r++;
            } else {
                l++;
            }
        }

        return res;
    }
}
