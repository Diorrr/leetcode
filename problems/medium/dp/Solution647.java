package problems.medium.dp;

/**
 * Problem: https://leetcode.com/problems/palindromic-substrings/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution647 {
    // solution from comments
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (i - 1 < j + 1 || dp[i - 1][j + 1]);
                if (dp[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }

    Integer count = 0;

    public int countSubstrings1(String s) {
        for (int i = 0; i < s.length(); i++) {
            countFrom(s, i, i);
            countFrom(s, i, i + 1);
        }

        return count;
    }

    private void countFrom(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }
    }

    public int countSubstrings2(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && isPalindrome(s.substring(j, i + 1))) {
                    res++;
                }
            }
        }
        return res;
    }

    boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
