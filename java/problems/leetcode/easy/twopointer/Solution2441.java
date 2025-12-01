package problems.leetcode.easy.twopointer;


import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: <a href="https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative">
 * largest-positive-integer-that-exists-with-its-negative</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2441 {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] == 0) {
                return nums[r];
            } else if (-nums[l] > nums[r]) {
                l++;
            } else {
                r--;
            }
        }
        return -1;
    }

    public int findMaxK2(int[] nums) {
        int res = -1;
        Set<Integer> posSet = Arrays.stream(nums).filter(num -> num > 0).boxed().collect(Collectors.toSet());
        for (int num : nums) {
            if (num < 0 && res < -num && posSet.contains(-num)) {
                res = -num;
            }
        }
        return res;
    }
}
