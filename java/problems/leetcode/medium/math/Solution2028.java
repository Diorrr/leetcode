package problems.leetcode.medium.math;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/find-missing-observations">
 * find-missing-observations</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] res = new int[n];
        int sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }
        int rest = (rolls.length + n) * mean - sum;
        int toAdd = rest / n;
        if ((rest > toAdd * n && toAdd == 6) || toAdd > 6 || rest < n) {
            return new int[]{};
        }
        rest -= toAdd * res.length;
        for (int i = 0; i < res.length; i++) {
            res[i] = toAdd;
        }
        for (int i = 0; i < res.length && rest > 0; i++) {
            res[i]++;
            rest--;
        }

        return res;
    }

    public int[] missingRolls2(int[] rolls, int mean, int n) {
        int[] res = new int[n];
        int rest = (rolls.length + n) * mean - Arrays.stream(rolls).sum();
        if ((rest > (rest / n) * n && rest / n == 6) || rest / n > 6 || rest < n) {
            return new int[]{};
        }
        int toAdd = rest / n;
        rest -= toAdd * res.length;
        Arrays.fill(res, toAdd);
        for (int i = 0; i < res.length && rest > 0; i++) {
            res[i]++;
            rest--;
        }

        return res;
    }
}
