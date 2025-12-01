package problems.leetcode.medium.greedy;


/**
 * Problem: <a href="https://leetcode.com/problems/jump-game-ii">
 * jump-game-ii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution45 {
    public int jump(int[] nums) {
        int res = 0;
        int curEnd = 0;
        int curMax = 0;

        for (int i = 0; i < nums.length; i++) {
            curMax = Math.max(i + nums[i], curMax);
            if (i == curEnd) {
                res++;
                curEnd = curMax;
            }
        }

        return res;
    }

    public int jump1(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int res = 0;
        int pos = 0;
        int maxJump = 0;
        while (pos < nums.length) {
            int nextMaxJump = maxJump;
            while (pos <= maxJump) {
                nextMaxJump = Math.max(pos + nums[pos], nextMaxJump);
                pos++;
                if (pos == nums.length || nextMaxJump >= nums.length - 1) {
                    res++;
                    return res;
                }
            }
            res++;
            maxJump = nextMaxJump;
        }

        return res;
    }

    public int jump2(int[] nums) {
        int[] steps = new int[nums.length];
        boolean[] reach = new boolean[nums.length];
        reach[0] = true;
        for (int i = 1; i < steps.length; i++) {
            steps[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < steps.length; i++) {
            if (reach[i]) {
                for (int j = i + 1; j < Math.min(i + nums[i] + 1, nums.length); j++) {
                    reach[j] = true;
                    steps[j] = Math.min(steps[i] + 1, steps[j]);
                }
            }
        }

        return steps[steps.length - 1];
    }
}
