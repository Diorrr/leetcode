package problems.medium.arrays;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/longest-consecutive-sequence/
 * Time Complexity:
 * Space Complexity：
 */
class Solution128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        SortedSet<Integer> set = new TreeSet<>();
        int count = 1, res = 1;
        Arrays.stream(nums).forEach(set::add);
        List<Integer> sortedNums = new ArrayList<>(set);
        for (int i = 1; i < sortedNums.size(); i++) {
            if (sortedNums.get(i) == (sortedNums.get(i - 1) + 1)) {
                count++;
            } else {
                count = 1;
            }
            res = Math.max(count, res);
        }

        return res;
    }
}
