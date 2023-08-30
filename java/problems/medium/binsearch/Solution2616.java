package problems.medium.binsearch;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs">
 * minimize-the-maximum-difference-of-pairs</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2616 {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        while (left < right) {
            int mid = (left + right) / 2;
            if (canFormPairs(nums, p, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canFormPairs(int[] nums, int p, int diff) {
        int count = 0;
        for (int i = 1; count < p && i < nums.length; i++) {
            if (nums[i] - nums[i - 1] <= diff) {
                count++;
                i++;
            }
        }

        return count == p;
    }
}
