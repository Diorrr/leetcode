package problems.leetcode.hard.arrays;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/candy">
 * problem</a>
 * Time Complexity: O(N^2)
 * Space Complexity：
 */
class Solution135 {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            candies[i] = 1;
            if (ratings[i - 1] > ratings[i] && candies[i - 1] == 1) {
                for (int j = i - 1; j >= 0 && ratings[j] > ratings[j + 1] && candies[j] == candies[j + 1]; j--) {
                    candies[j] = candies[j + 1] + 1;
                }
            }
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        return Arrays.stream(candies).sum();
    }
}
