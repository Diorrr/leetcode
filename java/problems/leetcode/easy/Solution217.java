package problems.leetcode.easy;

import java.util.HashSet;

/**
 * Problem: https://leetcode.com/problems/contains-duplicate/
 * Time Complexity: O(N)
 * Space Complexity： O(1)
 */
class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
