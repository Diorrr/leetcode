package problems.medium.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: https://leetcode.com/problems/find-the-duplicate-number/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution287 {
    public int findDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }

        return 0;
    }

    public int findDuplicate(int[] nums) {
        int[] used = new int[nums.length + 2];
        for (int num : nums) {
            if (used[num] > 0) {
                return num;
            }
            used[num]++;
        }

        return 0;
    }
}
