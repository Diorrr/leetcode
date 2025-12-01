package problems.leetcode.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/summary-ranges">
 * summary-ranges</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        int ind = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 != nums[i]) {
                if (ind == i - 1) {
                    res.add(String.valueOf(nums[ind]));
                } else {
                    res.add(nums[ind] + "->" + nums[i - 1]);
                }
                ind = i;
            }
        }
        if (ind == nums.length - 1) {
            res.add(String.valueOf(nums[ind]));
        } else {
            res.add(nums[ind] + "->" + nums[nums.length - 1]);
        }
        return res;
    }
}
