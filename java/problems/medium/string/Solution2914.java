package problems.medium.string;


/**
 * Problem: <a href="https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful">
 * minimum-number-of-changes-to-make-binary-string-beautiful</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2914 {
    public int minChanges(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                res++;
            }
        }
        return res;
    }
}
