package problems.medium.sorting;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/maximize-happiness-of-selected-children">
 * maximize-happiness-of-selected-children</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3075 {
    public long maximumHappinessSum(int[] happiness, int k) {
        long res = 0;
        Arrays.sort(happiness);
        for (int i = 0; i < k && happiness[happiness.length - 1 - i] > i; i++) {
            res += happiness[happiness.length - 1 - i] - i;
        }
        return res;
    }
}
