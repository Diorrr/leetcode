package problems.medium.counting;


/**
 * Problem: <a href="https://leetcode.com/problems/minimum-length-of-string-after-operations">
 * minimum-length-of-string-after-operations</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3223 {
    public int minimumLength(String s) {
        int res = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (int letterCount : count) {
            if (letterCount > 0) {
                res -= letterCount % 2 == 1 ? letterCount - 1 : letterCount - 2;
            }
        }
        return res;
    }
}
