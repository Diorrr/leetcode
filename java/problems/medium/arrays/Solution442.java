package problems.medium.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/find-all-duplicates-in-an-array">
 * find-all-duplicates-in-an-array</a>
 * Time Complexity: O(N)
 * Space Complexity： O(N)
 */
class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int num : nums) {
            int idx = Math.abs(num) - 1;
            if (nums[idx] < 0) {
                res.add(idx + 1);
            }
            nums[idx] = -nums[idx];
        }

        return res;
    }

    public List<Integer> findDuplicates2(int[] nums) {
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
