package problems.leetcode.medium.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/task-scheduler/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int maxOcc = 0;
        int maxCount = 0;

        for (char task : tasks) {
            count[task - 'A']++;
        }
        for (int countChar : count) {
            if (countChar > maxOcc) {
                maxOcc = countChar;
                maxCount = 1;
            } else if (countChar == maxOcc) {
                maxCount++;
            }
        }
        if (maxOcc == 1) {
            return tasks.length;
        }
        int rest = tasks.length - maxOcc * maxCount;

        return maxCount + rest / (maxOcc - 1) > n ? tasks.length : (maxOcc - 1) * (n + 1) + maxCount;
    }

    public int leastInterval2(char[] tasks, int n) {
        List<int[]> list = new ArrayList<>();
        for (char i = 'A'; i <= 'Z'; i++) {
            int count = count(i, tasks);
            if (count != 0) {
                list.add(new int[]{count, i});
            }
        }
        list.sort((a, b) -> b[0] - a[0]);
        List<List<Character>> res = new ArrayList<>();
        for (int i = 0; i < list.get(0)[0]; i++) {
            res.add(new ArrayList<>());
        }
        int index = 0;
        for (int[] ints : list) {
            char toAdd = (char) ints[1];
            for (int j = 0; j < ints[0]; j++) {
                res.get(index).add(toAdd);
                if (ints[0] == list.get(0)[0]) {
                    index = (index + 1) % res.size();
                } else {
                    index = (index + 1) % (res.size() - 1);
                }
            }
        }
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i).size() < n + 1) {
                res.get(i).addAll(Arrays.asList(new Character[n + 1 - res.get(i).size()]));
            }
        }

        return res.stream().map(List::size).reduce(0, (a, b) -> a += b);
    }

    private int count(char charToCount, char[] s) {
        return Arrays.toString(s).chars().filter(c -> c == charToCount).toArray().length;
    }
}
