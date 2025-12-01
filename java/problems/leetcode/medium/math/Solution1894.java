package problems.leetcode.medium.math;


/**
 * Problem: <a href="https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk">
 * find-the-student-that-will-replace-the-chalk</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1894 {
    public int chalkReplacer(int[] chalk, int k) {
        while (k >= 0) {
            for (int i = 0; i < chalk.length; i++) {
                if (k > chalk[i]) {
                    k -= chalk[i];
                } else {
                    return i;
                }
            }
        }
        return 0;
    }

    public int chalkReplacer2(int[] chalk, int k) {
        long sum = 0;
        long rest = k;
        for (int j : chalk) {
            sum += j;
        }
        rest %= sum;
        for (int i = 0; i < chalk.length; i++) {
            if (rest > chalk[i]) {
                rest -= chalk[i];
            } else {
                return i;
            }
        }
        return 0;
    }
}
