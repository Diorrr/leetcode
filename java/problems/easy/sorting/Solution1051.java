package problems.easy.sorting;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/height-checker">
 * height-checker</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1051 {
    public int heightChecker(int[] heights) {
        int res = 0;
        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                res++;
            }
        }
        return res;
    }
}
