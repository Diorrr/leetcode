package problems.leetcode.medium.prefixsum;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/find-polygon-with-the-largest-perimeter">
 * find-polygon-with-the-largest-perimeter</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2971 {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long res = -1;
        long pref = nums[0] + nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (pref > nums[i]) {
                res = pref + nums[i];
            }
            pref += nums[i];
        }
        return res;
    }
}
