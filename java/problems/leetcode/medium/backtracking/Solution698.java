package problems.leetcode.medium.backtracking;

import java.util.Arrays;

/**
 * Problem: https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution698 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        boolean[] used = new boolean[nums.length];
        return canPartition(nums, used, 0, k, 0, sum / k);
    }

    private boolean canPartition(int[] nums, boolean[] used, int index, int k, int sumCurr, int target) {
        if (k == 1) {
            return true;
        }
        if (sumCurr == target) {
            return canPartition(nums, used, 0, k - 1, 0, target);
        }
        if (sumCurr > target) {
            return false;
        }
        for (int i = index; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                if (canPartition(nums, used, i + 1, k, sumCurr + nums[i], target)) {
                    return true;
                }
                used[i] = false;
            }
        }

        return false;
    }
}
