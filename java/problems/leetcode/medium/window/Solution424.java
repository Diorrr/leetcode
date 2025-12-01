package problems.leetcode.medium.window;

/**
 * Problem: https://leetcode.com/problems/longest-repeating-character-replacement/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution424 {
    public int characterReplacement(String s, int k) {
        int maxOcc = 0, start = 0, res = 0;
        int[] count = new int[26];

        for (int end = 0; end < s.length(); end++) {
            maxOcc = Math.max(maxOcc, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 > maxOcc + k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}
