package problems.leetcode.medium.counting;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/task-scheduler">
 * task-scheduler</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        Arrays.sort(count);
        int size = count[25] - 1;
        int res = size * n;
        for (int i = 24; i >= 0; i--) {
            res -= Math.min(size, count[i]);
        }

        return tasks.length + Math.max(res, 0);
    }
}
