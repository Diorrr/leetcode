package problems.leetcode.hard.window;


/**
 * Problem: <a href="https://leetcode.com/problems/minimum-window-substring">
 * minimum-window-substring</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution76 {
    public String minWindow(String s, String t) {
        int[] count = new int[128];
        int found = t.length();
        int start = 0;
        int end = 0;
        int length = Integer.MAX_VALUE;
        int startInd = 0;

        for (char tChar : t.toCharArray()) {
            count[tChar]++;
        }

        while (end < s.length()) {
            if (count[s.charAt(end++)]-- > 0) {
                found--;
            }
            while (found == 0) {
                if (end - start < length) {
                    length = end - start;
                    startInd = start;
                }
                if (count[s.charAt(start++)]++ == 0){
                    found++;
                }
            }
        }

        return length != Integer.MAX_VALUE ? s.substring(startInd, startInd + length) : "";
    }
}
