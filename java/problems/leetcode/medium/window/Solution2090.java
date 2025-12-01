package problems.leetcode.medium.window;


import java.math.BigInteger;
import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/k-radius-subarray-averages">
 * k-radius-subarray-averages</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2090 {
    public int[] getAverages(int[] nums, int k) {
        int[] res = new int[nums.length];
        if (2 * k >= nums.length) {
            Arrays.fill(res, -1);
        } else {
            for (int i = 0; i < k; i++) {
                res[i] = -1;
            }
            for (int i = nums.length - k; i < nums.length; i++) {
                res[i] = -1;
            }
            BigInteger sum = BigInteger.ZERO;

            for (int i = 0; i < 2 * k + 1; i++) {
                sum = sum.add(BigInteger.valueOf(nums[i]));
            }
            BigInteger numberOfElems = BigInteger.valueOf(2L * k + 1L);
            res[k] = sum.divide(numberOfElems).intValue();

            for (int i = k + 1; i < nums.length - k; i++) {
                sum = sum.subtract(BigInteger.valueOf(nums[i - k - 1])).add(BigInteger.valueOf(nums[i + k]));
                res[i] = sum.divide(numberOfElems).intValue();
            }
        }

        return res;
    }
}
