package problems.medium.arrays;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times">
 * count-subarrays-where-max-element-appears-at-least-k-times</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2962 {
    public long countSubarrays(int[] nums, int k) {
        long res = 0;
        int max = Arrays.stream(nums).max().getAsInt();
        int left = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == max ? 1 : 0;
            while (count >= k) {
                count -= nums[left++] == max ? 1 : 0;
            }
            res += left;
        }
        return res;
    }
}
