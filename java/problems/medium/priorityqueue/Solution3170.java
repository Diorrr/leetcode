package problems.medium.priorityqueue;

import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars">
 * lexicographically-minimum-string-after-removing-stars</a>
 * Time Complexity: O(n log n), where n is the length of the string s.
 * Space Complexity：
 */
class Solution3170 {
    public String clearStars(String s) {
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        char[] chars = s.toCharArray();
        int starCount = 0;

        for (int i = 0; i < chars.length; i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '*') {
                starCount++;
                if (starCount > 0) {
                    starCount--;
                    chars[pq.poll()[1]] = '*';
                }
            } else {
                pq.add(new int[]{currentChar, i});
            }
        }
        while (starCount > 0 && !pq.isEmpty()) {
            chars[pq.poll()[1]] = '*';
            starCount--;
        }
        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            if (c != '*') {
                result.append(c);
            }
        }

        return result.toString();
    }
}
