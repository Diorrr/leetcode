package problems;

import java.util.HashSet;

/**
 * Problem: https://leetcode.com/problems/contains-duplicate/
 * Time Complexity: O(N)
 * Space Complexity：
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

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 1};
        System.out.println((new Solution217().containsDuplicate(input)));
    }
}
