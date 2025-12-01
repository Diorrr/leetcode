package problems.leetcode.medium.window;

/**
 * Problem: <a href="https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length">
 * maximum-number-of-vowels-in-a-substring-of-given-length</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1456 {
    public int maxVowels(String s, int k) {
        int res = 0;
        int cur = 0;
        char[] sChar = s.toCharArray();
        boolean[] isVowel = new boolean[26];
        isVowel['a' - 'a'] = true;
        isVowel['e' - 'a'] = true;
        isVowel['i' - 'a'] = true;
        isVowel['o' - 'a'] = true;
        isVowel['u' - 'a'] = true;
        for (int i = 0; i < Math.min(sChar.length, k); i++) {
            if (isVowel[sChar[i] - 'a']) {
                cur++;
            }
        }
        res = Math.max(res, cur);
        for (int i = k; i < sChar.length; i++) {
            if (isVowel[sChar[i] - 'a']) {
                cur++;
            }
            if (isVowel[sChar[i - k] - 'a']) {
                cur--;
            }
            res = Math.max(res, cur);
        }

        return res;
    }
}
