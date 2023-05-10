package problems.medium.window;

/**
 * Problem: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 * Time Complexity:
 * Space Complexity：
 */
class Solution1456 {
    public int maxVowels(String s, int k) {
        int res = 0;
        int cur = 0;
        for (int i = 0; i < Math.min(s.length(), k); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i'
                    || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                cur++;
            }
        }
        res = Math.max(res, cur);
        for (int i = k; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i'
                    || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                cur++;
            }
            if (s.charAt(i - k) == 'a' || s.charAt(i - k) == 'e' || s.charAt(i - k) == 'i'
                    || s.charAt(i - k) == 'o' || s.charAt(i - k) == 'u') {
                cur--;
            }
            res = Math.max(res, cur);
        }

        return res;
    }
}
