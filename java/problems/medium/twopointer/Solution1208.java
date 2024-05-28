package problems.medium.twopointer;


/**
 * Problem: <a href="https://leetcode.com/problems/get-equal-substrings-within-budget">
 * get-equal-substrings-within-budget</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int res = 0;
        int l = 0;
        int r = 0;
        int[] diff = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            diff[i + 1] = diff[i] + Math.abs(s.charAt(i) - t.charAt(i));
        }
        while (r != s.length()) {
            if (diff[r + 1] - diff[l] <= maxCost) {
                r++;
                res = Math.max(r - l, res);
            } else {
                if (l == r) {
                    r++;
                }
                l++;
            }
        }
        return res;
    }
}
