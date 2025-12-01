package problems.leetcode.medium.bfs;


import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: <a href="https://leetcode.com/problems/open-the-lock">
 * open-the-lock</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution752 {
    public int openLock(String[] deadends, String target) {
        int turns = 0;
        Set<String> deadendsSet = Arrays.stream(deadends).collect(Collectors.toSet());
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("0000");
        visited.add("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size--;
                String curr = queue.poll();
                if (deadendsSet.contains(curr)) {
                    continue;
                } else if (curr.equals(target)) {
                    return turns;
                }
                StringBuilder sb = new StringBuilder(curr);
                for (int i = 0; i < 4; i++) {
                    char c = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
                    if (!visited.contains(s1) && !deadendsSet.contains(s1)) {
                        queue.add(s1);
                        visited.add(s1);
                    }
                    if (!visited.contains(s2) && !deadendsSet.contains(s2)) {
                        queue.add(s2);
                        visited.add(s2);
                    }
                }
            }
            turns++;
        }
        return -1;
    }
}
