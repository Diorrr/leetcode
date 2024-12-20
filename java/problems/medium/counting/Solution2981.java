package problems.medium.counting;


import java.util.HashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i">
 * find-longest-special-substring-that-occurs-thrice-i</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2981 {
    public int maximumLength(String s) {
        char[] chars = s.toCharArray();
        Map<String, Integer> count = new HashMap<>();
        int ind = 0;
        char prev = '.';
        StringBuilder sb = new StringBuilder();
        while (ind < chars.length) {
            if (prev == chars[ind]) {
                sb.append(chars[ind]);
            } else {
                int len = sb.length();
                while (!sb.isEmpty()) {
                    count.put(sb.toString(), count.getOrDefault(sb.toString(), 0) + (len - sb.length()));
                    sb.deleteCharAt(0);
                }
                sb = new StringBuilder();
                sb.append(chars[ind]);
            }
            prev = chars[ind];
            ind++;
            count.put(sb.toString(), count.getOrDefault(sb.toString(), 0) + 1);
        }
        int len = sb.length();
        while (!sb.isEmpty()) {
            count.put(sb.toString(), count.getOrDefault(sb.toString(), 0) + (len - sb.length()));
            sb.deleteCharAt(0);
        }
        return count.entrySet().stream()
                    .filter(e -> e.getValue() > 2)
                    .mapToInt(e -> e.getKey().length())
                    .max()
                    .orElse(-1);
    }
}
