package problems.easy.array;


/**
 * Problem: <a href="https://leetcode.com/problems/count-the-number-of-consistent-strings">
 * count-the-number-of-consistent-strings</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        int res = words.length;
        boolean[] toUse = new boolean[26];
        for (char c : allowed.toCharArray()) {
            toUse[c - 'a'] = true;
        }
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!toUse[c - 'a']) {
                    res--;
                    break;
                }
            }
        }

        return res;
    }
}
