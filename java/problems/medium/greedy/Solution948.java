package problems.medium.greedy;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/bag-of-tokens">
 * bag-of-tokens</a>
 * Time Complexity: O(N)
 * Space Complexity：
 */
class Solution948 {
    public int bagOfTokensScore(int[] tokens, int power) {
        if (tokens.length == 1) {
            return tokens[0] <= power ? 1 : 0;
        }
        int score = 0;
        int res = 0;
        Arrays.sort(tokens);
        int r = tokens.length - 1;
        for (int l = 0; l <= r; l++) {
            if (tokens[l] <= power) {
                power -= tokens[l];
                res++;
            } else if (score > 0) {
                power += tokens[r];
                res--;
                l--;
                r--;
            }
            score = Math.max(res, score);
        }

        return score;
    }
}
