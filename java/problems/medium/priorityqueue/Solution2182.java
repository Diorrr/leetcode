package problems.medium.priorityqueue;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/construct-string-with-repeat-limit">
 * construct-string-with-repeat-limit</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2182 {
    public String repeatLimitedString(String s, int repeatLimit) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> -a[0]));

        for (char aChar : chars) {
            count[aChar - 'a']++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                queue.add(new int[]{i, count[i]});
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int toAdd = Math.min(cur[1], repeatLimit);
            sb.append((String.valueOf((char) ('a' + cur[0]))).repeat(toAdd));
            cur[1] -= toAdd;
            if (cur[1] > 0) {
                if (!queue.isEmpty()) {
                    int[] next = queue.poll();
                    sb.append((char) ('a' + next[0]));
                    next[1]--;
                    if (next[1] > 0) {
                        queue.add(next);
                    }
                    queue.add(cur);
                }
            }
        }

        return sb.toString();
    }

    public String repeatLimitedString2(String s, int repeatLimit) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        boolean[] used = new boolean[chars.length];
        Arrays.sort(chars);
        char prev = '*';
        int count = 0;
        int pos = chars.length - 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (!used[i]) {
                if (chars[i] != prev) {
                    sb.append(chars[i]);
                    count = 1;
                    prev = chars[i];
                } else if (count < repeatLimit) {
                    sb.append(chars[i]);
                    count++;
                } else {
                    for (pos = Math.min(i - 1, pos); pos >= 0; pos--) {
                        if (!used[pos] && chars[i] != chars[pos]) {
                            sb.append(chars[pos]);
                            sb.append(chars[i]);
                            count = 1;
                            used[pos] = true;
                            break;
                        }
                    }
                    if (count != 1) {
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
}
