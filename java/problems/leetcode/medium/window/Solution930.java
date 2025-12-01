package problems.leetcode.medium.window;

/**
 * Problem: <a href="https://leetcode.com/problems/binary-subarrays-with-sum">
 * binary-subarrays-with-sum</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        if (nums.length == 1) {
            return nums[0] == goal ? 1 : 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == goal) {
                    res++;
                }
            }
        }

        return res;
    }
}
