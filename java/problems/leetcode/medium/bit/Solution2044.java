package problems.leetcode.medium.bit;


import java.util.HashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets">
 * count-number-of-maximum-bitwise-or-subsets</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2044 {
    public int countMaxOrSubsets(int[] nums) {
        int[] dp = new int[1 << 17];
        int max = 0;
        dp[0] = 1;
        for (int num : nums) {
            for (int i = max; i >= 0; i--) {
                dp[i | num] += dp[i];
            }
            max |= num;
        }

        return dp[max];
    }

    public int countMaxOrSubsets1(int[] nums) {
        int res = 0;
        int max = 0;
        for (int num : nums) {
            max |= num;
        }
        for (int i = 0; i < 1 << nums.length; i++) {
            int cur = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    cur = cur | nums[j];
                }
            }
            if (cur == max) {
                res++;
            }
        }
        return res;
    }

    public int countMaxOrSubsets2(int[] nums) {
        int max = nums[0];
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < 1 << nums.length; i++) {
            int cur = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    cur = cur | nums[j];
                }
            }
            count.put(cur, count.getOrDefault(cur, 0) + 1);
            max = Math.max(cur, max);
        }
        return count.get(max);
    }
}
