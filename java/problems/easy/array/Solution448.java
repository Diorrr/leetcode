package problems.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * Time Complexity: O(N)
 * Space Complexity： O(N)
 */
class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] mask = new int[nums.length + 1];
        for (int num : nums) {
            mask[num] = 1;
        }
        for (int i = 1; i < nums.length + 1; i++) {
            if (mask[i] != 1) {
                res.add(i);
            }
        }
        return res;
    }
}
