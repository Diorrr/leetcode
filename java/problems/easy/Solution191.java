package problems.easy;

import java.util.*;
import java.util.stream.Stream;

/**
 * Problem: https://leetcode.com/problems/number-of-1-bits/
 * Time Complexity:
 * Space Complexity：
 */
class Solution191 {
    public int hammingWeight(int n) {
        int res = 0;
        for (int j = 0; j < 32; j++) {
            if ((n & (1L << j)) != 0) {
                res++;
            }
        }
        return res;
    }
}
