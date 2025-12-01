package problems.leetcode.medium.math;

/**
 * Problem: <a href="https://leetcode.com/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1">
 * minimum-number-of-operations-to-make-all-array-elements-equal-to-1</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2654 {
    public int minOperations(int[] nums) {
        int numberOfOnes = 0;
        for (int num : nums) {
            if (num == 1) {
                numberOfOnes++;
            }
        }
        if (numberOfOnes > 0) {
            return nums.length - numberOfOnes;
        }
        int minOps = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentGCD = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                currentGCD = getGCD(currentGCD, nums[j]);
                if (currentGCD == 1) {
                    minOps = Math.min(minOps, j - i + nums.length - 1);
                    break;
                }
            }
        }
        if (minOps != Integer.MAX_VALUE) {
            return nums.length + minOps - 1;
        }
        return -1;
    }

    private int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }
}
