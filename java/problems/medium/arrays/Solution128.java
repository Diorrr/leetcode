package problems.medium.arrays;

import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/longest-consecutive-sequence">
 * longest-consecutive-sequence</a>
 * Time Complexity: O(NlogN)
 * Space Complexity：
 */
class Solution128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int res = 0;
        int count = 1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                count++;
            } else if (nums[i] != nums[i - 1]) {
                count = 1;
            }
            res = Math.max(count, res);
        }

        return res;
    }

    public int longestConsecutive1(int[] nums) {
        int res = 0;
        int count = 1;
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num, num);
        }
        for (int num : nums) {
            count = 1;
            int x = num;
            if (map.get(x + 1) == null) {
                while (map.get(x - 1) != null) {
                    count++;
                    x--;
                }
            }
            res = Math.max(count, res);
        }

        return res;
    }
}
