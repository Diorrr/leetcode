package problems.medium.prefixsum;


import java.util.HashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/subarray-sum-equals-k">
 * subarray-sum-equals-k</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution560 {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0] == k ? 1 : 0;
        }

        int res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (count.containsKey(sum - k)) {
                res += count.get(sum - k);
            }
            count.putIfAbsent(sum, 0);
            count.put(sum, count.get(sum) + 1);
        }
        return res;
    }

    public int subarraySum2(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0] == k ? 1 : 0;
        }

        int res = 0;
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < prefix.length; i++) {
            for (int j = i + 1; j < prefix.length; j++) {
                if (prefix[j] - prefix[i] == k) {
                    res++;
                }
            }

        }

        return res;
    }
}
