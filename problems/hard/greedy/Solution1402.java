package problems.hard.greedy;

import java.util.Arrays;

/**
 * Problem: https://leetcode.com/problems/reducing-dishes/
 * Time Complexity:
 * Space Complexity：
 */
class Solution1402 {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int res = 0;
        for (int i = 0; i < satisfaction.length; i++) {
            int cur = 0, time = 1;
            for (int j = i; j < satisfaction.length; j++) {
                cur += time * satisfaction[j];
                time++;
            }
            res = Math.max(res, cur);
        }

        return res;
    }
}
