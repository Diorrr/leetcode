package problems.easy;

import java.util.Arrays;

/**
 * Problem: https://leetcode.com/problems/two-sum/
 * Time Complexity: O(N*logN)
 * Space Complexity： O(N)
 */
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int[] copy = Arrays.copyOf(nums, nums.length);
        int first = 0, second = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int l = -1, r = nums.length;
            int m;
            while (l < r - 1) {
                m = (l + r) / 2;
                if (i != m && nums[m] == target - nums[i]) {
                    first = nums[i];
                    second = nums[m];
                    break;
                } else if (nums[m] < target - nums[i]) {
                    l = m;
                } else {
                    r = m;
                }
            }
        }

        for (int i = 0; i < copy.length; i++) {
            if (copy[i] == first) {
                res[0] = i;
            }

        }
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] == second && i != res[0]) {
                res[1] = i;
            }
        }
        Arrays.sort(res);

        return res;
    }
}
