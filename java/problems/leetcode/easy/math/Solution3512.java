package problems.leetcode.easy.math;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k">
 * minimum-operations-to-make-array-sum-divisible-by-k</a>
 * Time Complexity: O(N)
 * Space Complexity：O(1)
 */
class Solution3512 {
    public int minOperations(int[] nums, int k) {
        int res = 0;
        for (int num : nums) {
            res += num % k;
        }
        return res % k;
    }

    public int minOperations1(int[] nums, int k) {
        return Arrays.stream(nums).sum() % k;
    }
}
