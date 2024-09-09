package problems.medium.math;


import java.util.HashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/count-number-of-nice-subarrays">
 * count-number-of-nice-subarrays</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int res = 0;
        int l = 0;
        int r = 0;
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] %= 2;
        }
        while (r < nums.length) {
            if (nums[r] == 1) {
                sum++;
                count = 0;
            }
            while (sum == k) {
                count++;
                sum -= nums[l++];
            }
            res += count;
            r++;
        }

        return res;
    }

    public int numberOfSubarrays2(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        for (int num : nums) {
            sum += num % 2;
            res += count.getOrDefault(sum - k, 0);
            count.put(sum, count.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
