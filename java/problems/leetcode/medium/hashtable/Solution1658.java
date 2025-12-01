package problems.leetcode.medium.hashtable;


import java.util.HashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero">
 * minimum-operations-to-reduce-x-to-zero</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1658 {
    public int minOperations(int[] nums, int x) {
        int res = Integer.MAX_VALUE;
        Map<Integer, Integer> sufIndex = new HashMap<>();
        sufIndex.put(0, 0);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sufIndex.put(sum, i + 1);
        }

        if (sufIndex.containsKey(x)) {
            res = sufIndex.get(x);
        }

        sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            Integer index = sufIndex.get(x - sum);
            if (index != null && index <= i) {
                res = Math.min(nums.length - i + index, res);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
