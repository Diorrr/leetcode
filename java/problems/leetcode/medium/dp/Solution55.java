package problems.leetcode.medium.dp;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/jump-game">
 * jump-game</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution55 {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for (int i = 0; i <= maxJump; i++) {
            maxJump = Math.max(i + nums[i], maxJump);
            if (maxJump >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump1(int[] nums) {
        if (Arrays.stream(nums).sum() < nums.length - 1) {
            return false;
        }
        boolean[] reach = new boolean[nums.length];
        reach[0] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (reach[j] && j + nums[j] >= i) {
                    reach[i] = true;
                    break;
                }
            }
        }

        return reach[reach.length - 1];
    }

    public boolean canJump2(int[] nums) {
        boolean[] reach = new boolean[nums.length];
        reach[0] = true;

        for (int i = 0; i < nums.length && !reach[reach.length - 1]; i++) {
            if (reach[i]) {
                for (int j = i; j < Math.min(reach.length, i + nums[i] + 1); j++) {
                    reach[j] = true;
                }
            }
        }

        return reach[reach.length - 1];
    }
}
