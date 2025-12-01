package problems.leetcode.medium.sorting;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/largest-number">
 * largest-number</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution179 {
    public String largestNumber(int[] nums) {
        StringBuilder res = new StringBuilder();
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        if (strings[0].equals("0")) {
            return "0";
        }
        for (String num : strings) {
            res.append(num);
        }

        return res.toString();
    }
}
