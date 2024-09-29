package problems.medium.treemap;


import java.util.TreeMap;

/**
 * Problem: <a href="https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit">
 * longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1438 {
    public int longestSubarray(int[] nums, int limit) {
        int i = 0;
        int j = 0;
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (; j < nums.length; j++) {
            count.put(nums[j], 1 + count.getOrDefault(nums[j], 0));
            if (count.lastEntry().getKey() - count.firstEntry().getKey() > limit) {
                count.put(nums[i], count.get(nums[i]) - 1);
                if (count.get(nums[i]) == 0)
                    count.remove(nums[i]);
                i++;
            }
        }
        return j - i;
    }
}
