package problems.leetcode.easy.string;

/**
 * Problem: <a href="https://leetcode.com/problems/valid-anagram">
 * valid-anagram</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution242 {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
