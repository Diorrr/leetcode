package problems.leetcode.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/binary-prefix-divisible-by-5">
 * binary-prefix-divisible-by-5</a>
 * Time Complexity: O(N)
 * Space Complexity：O(N)
 */
class Solution1018 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>(nums.length);
        int mod = 0;
        for (int num : nums) {
            mod = (mod * 2 + num) % 5;
            res.add(mod % 5 == 0);
        }
        return res;
    }
}
