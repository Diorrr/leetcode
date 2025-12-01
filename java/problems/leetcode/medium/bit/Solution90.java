package problems.leetcode.medium.bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/subsets-ii/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());

        int prevResultSize = 1, startIndex;
        for (int i = 0; i < num.length; i++) {
            startIndex = (i > 0 && num[i] == num[i - 1]) ? prevResultSize : 0;
            prevResultSize = result.size();
            for (int j = startIndex; j < prevResultSize; j++) {
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(num[i]);
                result.add(temp);
            }
        }
        return result;
    }

    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1L << j)) != 0) {
                    curr.add(nums[j]);
                }
            }
            if (!result.contains(curr))
                result.add(curr);
        }

        return result;
    }
}
