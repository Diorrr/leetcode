package problems.easy.dp;

import java.util.Arrays;

/**
 * Problem: https://leetcode.com/problems/counting-bits/
 * Time Complexity:
 * Space Complexity：
 */
class Solution338 {
    public int[] countBits(int n) {
        if (n == 0) {
            return new int[]{0};
        } else if (n == 1) {
            return new int[]{0, 1};
        }
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        int pow2 = 2, index = 1;
        for (int i = 2; i < n + 1; i++) {
            // check for power of 2 can be done in more elegant and memory consuming way (i & (i - 1)) == 0
            if (i == pow2) {
                pow2 *= 2;
                index = i;
                res[i] = 1;
            } else {
                res[i] = res[index] + res[i - index];
            }
        }
        return res;
    }
}
