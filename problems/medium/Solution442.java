package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {
        int[] used = new int[nums.length + 1];
        List<Integer> res = new ArrayList<>();

        for (int num : nums) {
            used[num]++;
            if (used[num] == 2) {
                res.add(num);
            }
        }

        return res;
    }
}
